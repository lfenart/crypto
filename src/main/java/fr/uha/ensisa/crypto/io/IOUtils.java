package fr.uha.ensisa.crypto.io;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IOUtils {

	public static byte[] getBytes(File f) throws IOException {
		byte[] bytes = new byte[(int) f.length()];
		DataInputStream dis = new DataInputStream(new FileInputStream(f));
		dis.readFully(bytes);
		dis.close();
		return bytes;
	}

}
