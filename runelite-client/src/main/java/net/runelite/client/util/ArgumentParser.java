/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>, Anaganja <https://github.com/Anaganja>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.util;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.ValueConversionException;
import joptsimple.ValueConverter;
import joptsimple.util.EnumConverter;
import net.runelite.client.RuneLite;
import net.runelite.client.rs.ClientUpdateCheckMode;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Paths;

import static net.runelite.client.RuneLite.DEFAULT_CONFIG_FILE;
import static net.runelite.client.RuneLite.DEFAULT_SESSION_FILE;

public class ArgumentParser
{
    private final ArgumentAcceptingOptionSpec<File> sessionFile;
    private final ArgumentAcceptingOptionSpec<File> configFile;
    private final ArgumentAcceptingOptionSpec<ClientUpdateCheckMode> updateMode;

    private final OptionSet optionSet;

    public ArgumentParser(String[] args) throws Exception
    {
        final OptionParser parser = new OptionParser();
        parser.accepts("developer-mode", "Enable developer tools");
        parser.accepts("debug", "Show extra debugging output");
        parser.accepts("safe-mode", "Disables external plugins and the GPU plugin");
        parser.accepts("insecure-skip-tls-verification", "Disables TLS verification");

        sessionFile = parser.accepts("sessionfile", "Use a specified session file")
                .withRequiredArg()
                .withValuesConvertedBy(new ConfigFileConverter())
                .defaultsTo(DEFAULT_SESSION_FILE);

        configFile = parser.accepts("config", "Use a specified config file")
                .withRequiredArg()
                .withValuesConvertedBy(new ArgumentParser.ConfigFileConverter())
                .defaultsTo(DEFAULT_CONFIG_FILE);

        updateMode = parser.accepts("rs", "Select client type")
                .withRequiredArg()
                .ofType(ClientUpdateCheckMode.class)
                .defaultsTo(ClientUpdateCheckMode.AUTO)
                .withValuesConvertedBy(new EnumConverter<ClientUpdateCheckMode>(ClientUpdateCheckMode.class)
                {
                    @Override
                    public ClientUpdateCheckMode convert(String v)
                    {
                        return super.convert(v.toUpperCase());
                    }
                });

        parser.accepts("help", "Show this text").forHelp();
        optionSet = parser.parse(args);

        if (optionSet.has("help"))
        {
            parser.printHelpOn(System.out);
            System.exit(0);
        }

        if (optionSet.has("debug"))
        {
            final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
            logger.setLevel(Level.DEBUG);
        }
    }

    public OptionSet getOptionSet()
    {
        return optionSet;
    }

    public ArgumentAcceptingOptionSpec<File> getSessionFile()
    {
        return sessionFile;
    }

    public ArgumentAcceptingOptionSpec<File> getConfigFile()
    {
        return configFile;
    }

    public ArgumentAcceptingOptionSpec<ClientUpdateCheckMode> getUpdateMode()
    {
        return updateMode;
    }

    private static class ConfigFileConverter implements ValueConverter<File>
    {
        @Override
        public File convert(String fileName)
        {
            final File file;

            if (Paths.get(fileName).isAbsolute()
                    || fileName.startsWith("./")
                    || fileName.startsWith(".\\"))
            {
                file = new File(fileName);
            }
            else
            {
                file = new File(RuneLite.RUNELITE_DIR, fileName);
            }

            if (file.exists() && (!file.isFile() || !file.canWrite()))
            {
                throw new ValueConversionException(String.format("File %s is not accessible", file.getAbsolutePath()));
            }

            return file;
        }

        @Override
        public Class<? extends File> valueType()
        {
            return File.class;
        }

        @Override
        public String valuePattern()
        {
            return null;
        }
    }
}
