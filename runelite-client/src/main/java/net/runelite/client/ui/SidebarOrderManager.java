/*
 * Copyright (c) 2024, Smoke (Smoked today) <https://github.com/Varietyz>
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
package net.runelite.client.ui;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import net.runelite.client.RuneLite;

public class SidebarOrderManager {
    private static final File ORDER_FILE = new File(RuneLite.RUNELITE_DIR, "sidebar/sidebar_order.txt");

    public void saveOrder(List<NavigationButton> sidebarEntries) {
        ORDER_FILE.getParentFile().mkdirs();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDER_FILE))) {
            for (NavigationButton button : sidebarEntries) {
                writer.write(button.getTooltip());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<NavigationButton> loadOrder(List<NavigationButton> sidebarEntries) {
        if (!ORDER_FILE.exists()) {
            return null;
        }

        List<NavigationButton> orderedEntries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ORDER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (NavigationButton button : sidebarEntries) {
                    if (button.getTooltip().equals(line)) {
                        orderedEntries.add(button);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        for (NavigationButton button : sidebarEntries) {
            if (!orderedEntries.contains(button)) {
                orderedEntries.add(button);
            }
        }

        return orderedEntries;
    }
}