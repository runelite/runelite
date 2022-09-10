package net.runelite.api.packet;

import lombok.Data;
import net.runelite.api.packets.PacketBufferNode;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Data
public class PacketSent
{
    private final PacketBufferNode packetBufferNode;

    public String hexDump()
    {
        byte[] payload = Arrays.copyOfRange(
                packetBufferNode.getPacketBuffer().getPayload(),
                1, packetBufferNode.getPacketBuffer().getOffset());

        return "\n" + hexDump(
                payload,
                0,
                getPacketBufferNode().getPacketBuffer().getOffset()
        );
    }

    public static String hexDump(byte[] array, int offset, int length)
    {
        final int width = 16;

        StringBuilder builder = new StringBuilder();
        builder.append(Arrays.toString(array) + "\n");
        for (int rowOffset = offset; rowOffset < offset + length; rowOffset += width)
        {
            builder.append(String.format("%06d     ", rowOffset));

            for (int index = 0; index < width; index++)
            {
                if (rowOffset + index < array.length)
                {
                    builder.append(String.format("%02X ", array[rowOffset + index]));
                }
                else
                {
                    builder.append("   ");
                }
            }

            if (rowOffset < array.length)
            {
                int asciiWidth = Math.min(width, array.length - rowOffset);
                builder.append("     ");
                builder.append(new String(array, rowOffset, asciiWidth, StandardCharsets.UTF_8)
                        .replaceAll("\r\n", " ")
                        .replaceAll("\n", " ")
                );
            }

            builder.append(String.format("%n"));
        }

        return builder.toString();
    }
}