package com.cts.jsf.ui;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class App10CopyPasteDemo {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Source File name: ");
		String srcFileName = scan.nextLine();

		System.out.println("Destination File name: ");
		String destFileName = scan.nextLine();

		try (
				RandomAccessFile srcFile = new RandomAccessFile(srcFileName, "rw");
				RandomAccessFile destFile = new RandomAccessFile(destFileName, "rw");
		) {

			FileChannel srcChn = srcFile.getChannel();
			FileChannel destChn = destFile.getChannel();

			srcChn.transferTo(0, srcChn.size(), destChn);
		} catch (IOException e) {
			e.printStackTrace();
		}

		scan.close();
	}
}
