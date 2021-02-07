package com.shpp.p2p.cs.vkolisnichenko.assignment15;

import java.io.File;

/**
 * The main class in which objects are created and
 * methods are called to implement the Huffman algorithm.
 * The class also implements a method that collects information
 */
public class Assignment15Part1 {

    /**
     * A method in which, depending on the variable a,
     * the program decides whether it needs to be archived or
     * unzipped, the information is also displayed in the console
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //Get the start time of the program
        long timeMillis = System.currentTimeMillis();

        var readParameters = new ReadParameters();

        //get action (archive or unarchive)
        int getAction = readParameters.readParameters(args);

        //variables with filenames
        String inputFile = readParameters.getInputFile();
        String outputFile = readParameters.getOutputFile();

        if (getAction == 1) {
            Archive archive = new Archive(inputFile, outputFile);
            //archive file
            archive.archive();
        } else if (getAction == 2) {
            UnArchive unArchive = new UnArchive(inputFile, outputFile);
            //unarchive file
            unArchive.unArchive();
        }
        //write information to console
        getInformation(getAction, timeMillis, inputFile, outputFile);
    }

    /**
     * The method in which we output information about
     * the execution of the program to the console:
     * file size, execution time and efficiency
     *
     * @param operation  - get operation( archive or unarchive)
     * @param timeMillis - get start program time
     */
    private static void getInformation(int operation, long timeMillis
            , String inputFile, String outputFile) {
        if (operation == 1) {
            if (isInputFileLarger(inputFile, outputFile))
                System.out.println("Archiving was efficient");
            else System.out.println("Archiving was ineffective");
        } else if (operation == 2) {
            if (!isInputFileLarger(inputFile, outputFile))
                System.out.println("Archiving was ineffective");
            else System.out.println("Archiving was efficient");
        }
        System.out.println("execution time - " + (double)
                (System.currentTimeMillis() - timeMillis) / 1000 + " Seconds");
        if (operation == 1) {
            System.out.println("inputFile : " + getFileSizeBytes(new File(inputFile)) + " bytes");
            System.out.println("outputFile : " + getFileSizeBytes(new File(outputFile)) + " bytes");
        } else if (operation == 2) {
            System.out.println("inputFile : " + getFileSizeBytes(new File(outputFile)) + " bytes");
            System.out.println("outputFile : " + getFileSizeBytes(new File(inputFile)) + " bytes");
        }

    }

    /**
     * Check if the input file is greater than
     * the output and return a boolean value
     *
     * @return - true or false
     */
    private static boolean isInputFileLarger(String inputFile, String outputFile) {
        return getFileSizeBytes(new File(inputFile)) >= getFileSizeBytes(new File(outputFile));
    }

    /**
     * The method in which we get the size of the input file
     *
     * @param file - input file
     * @return - size
     */
    private static long getFileSizeBytes(File file) {
        return file.length();
    }


}

