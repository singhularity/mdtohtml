package com.singhulariti.mdtohtml;

import com.singhulariti.mdtohtml.dto.InputSource;
import com.singhulariti.mdtohtml.readers.CommandLineMarkdownReader;
import com.singhulariti.mdtohtml.readers.FileMarkdownReader;
import com.singhulariti.mdtohtml.readers.MarkdownReader;
import com.singhulariti.mdtohtml.writers.MarkDownWriter;
import com.singhulariti.mdtohtml.writers.StdOutWriter;
import jdk.jshell.spi.ExecutionControl;

import java.util.Locale;

public class Driver {

    public static void main(String[] args) throws ExecutionControl.NotImplementedException {
        if (args.length < 1) {
            throw new IllegalArgumentException("Invalid invocation, please specify source correctly!\n Valid options \nfile\nstdin");
        }
        InputSource source = InputSource.valueOf(args[0].toUpperCase(Locale.ROOT));
        if (source == InputSource.FILE && args.length < 2) {
            throw new IllegalArgumentException("Invalid invocation, please specify file path!");
        }
        MarkdownReader reader;
        if (source == InputSource.FILE) {
            String filePath = args[1];
            reader = new FileMarkdownReader(filePath);
        } else if (source == InputSource.STDIN) {
            reader = new CommandLineMarkdownReader();
        } else {
            throw new ExecutionControl.NotImplementedException("No implementation found for source: " + args[0]);
        }
        MarkDownWriter writer = new StdOutWriter();
        writer.writeContents(reader.readContent());
    }
}
