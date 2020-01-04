package fr.uha.ensisa.crypto.messaging;

import java.io.UnsupportedEncodingException;
import java.security.DigestException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.util.encoders.Hex;

import fr.uha.ensisa.crypto.mac.HMACException;
import fr.uha.ensisa.crypto.mac.MACAlgorithms;
import fr.uha.ensisa.crypto.mac.MACConfiguration;


public class MACGenerator {

	private String HMAC_KEY;
	private String dateFormat = "MM/dd/yyyy";

	/**
	 * 
	 * @param key
	 */
	public MACGenerator(String key) {
		this.HMAC_KEY = key;
	}

	/**
	 * 
	 * @param strength
	 * @param message
	 * @return
	 */
	public byte[] encodeMessage(String strength, String message, boolean isHex) {
		byte[] encodedMessage = null;
		Mac mac;

		if (strength == null) {
			strength = MACAlgorithms.ENCODING_STRENGTH_SHA512;
		}

		try {
			mac = Mac.getInstance(strength);
			SecretKeySpec secret_key;
			//secret_key = new SecretKeySpec(this.HMAC_KEY.getBytes(MACConfiguration.HMAC_KEY_ENCODING), strength);
			
			secret_key = new SecretKeySpec( tokenize(this.HMAC_KEY,isHex), strength);
			mac.init(secret_key);
			// Base64.encodeBase64String(sha256_HMAC.doFinal(data.getBytes(MACConfiguration.MESSAGE_ENCODING)));
			encodedMessage = Hex.encode(mac.doFinal(message.getBytes(MACConfiguration.MESSAGE_ENCODING)));

		} catch (NoSuchAlgorithmException e) {
			throw new HMACException("No such algorithm", e);
		} catch (IllegalStateException e) {
			throw new HMACException("Illegal state exception", e);
		} catch (UnsupportedEncodingException e) {
			throw new HMACException("Unsupported encoding exception", e);
		} catch (InvalidKeyException e) {
			throw new HMACException("Unsupported encoding exception", e);
		}

		return encodedMessage;

	}

	/**
	 * 
	 * @param strength
	 * @param ccid
	 * @param uuid
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public byte[] encodeMessage(String strength, String ccid, String uuid, String date, boolean isHex) throws Exception {
		return this.encodeMessage(strength, createMessage(ccid, uuid, date), isHex);
	}

	/**
	 * Message builded based on CSI WEB following parameters:
	 * 
	 * @param ccid
	 * @param uuid
	 * @param date
	 * @return
	 */
	private String createMessage(String ccid, String uuid, String date) {
		String patternToHash = ccid.toUpperCase() + getDateFormatted(date, this.dateFormat) + uuid;
		return patternToHash;
	}

	/**
	 * 
	 * @param dateStr
	 * @return
	 */
	private String getDateFormatted(String dateStr, String dateFormat) {
		SimpleDateFormat dt = new SimpleDateFormat(dateFormat);
		Date date = null;
		String formattedDate = null;

		try {
			date = dt.parse(dateStr);
			formattedDate = dt.format(date);
		} catch (ParseException e) {
			throw new HMACException("Date formattting exception", e);
		}

		return formattedDate;
	}


	/**
	 * 
	 * @param key
	 * @param keyIsHexString
	 * @return
	 */
	public byte[] tokenize(String key, boolean keyIsHexString) {
		if (null == key) {
			return null;
		}

		if (key.length() == 0) {
			return null;
		}

		byte[] bytes;
		if (keyIsHexString) {
			if ((key.length() % 2) != 0) {
				return null;
			}

			bytes = new byte[key.length() / 2];

			StringBuilder buf = new StringBuilder(2);
			for (int i = 0; i < key.length(); i++) {

				buf.append(key.charAt(i));
				if (buf.length() > 1) {
					byte[] array;
					try {
						array = Hex.decode(buf.toString());
					} catch (Exception e) {
						throw new HMACException("Cannot convert string value: " + buf.toString() + " to byte.", e);
					}
					bytes[(int) Math.floor((double) i / 2)] = array[0];

					buf.setLength(0);
					array = null;
				}
			}
		} else {
			bytes = new byte[key.length()];
			for (int i = 0; i < key.length(); i++)
				bytes[i] = (byte) key.charAt(i);
		}
		return bytes;
	}



}
