package net.runelite.client.chat;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by Jake on 2/10/2019.
 */
public class ChatMessageBuilderTest {

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private class MessageBuilderTest extends ChatMessageBuilder {

    }

    private class MessageBuilderTestB extends ChatMessageBuilder{

    }

    @Test
    public void testEquality(){
        ChatMessageBuilder cmb1 = new MessageBuilderTest();
        ChatMessageBuilder cmb2 = new MessageBuilderTest();
        ChatMessageBuilder cmb3 = new MessageBuilderTestB();

        assertTrue(cmb1.equals(cmb1));
        assertFalse(cmb1.equals(cmb2));
        assertFalse(cmb2.equals(cmb3));
    }

    @Test
    public void testAppendColorType(){
        ChatMessageBuilder cmb1 = new ChatMessageBuilder();
        ChatMessageBuilder cmb2 = new ChatMessageBuilder();

        cmb1.append(ChatColorType.HIGHLIGHT);
        cmb2.append(ChatColorType.NORMAL);

        String c1 = cmb1.build();
        String c2 = cmb2.build();

        assertTrue(c1.equals("<col"+ChatColorType.HIGHLIGHT.name()+">"));
        assertTrue(c2.equals("<col"+ChatColorType.NORMAL.name()+ ">"));

    }

    @Test
    public void testAppendMessage(){
        String message1 = randomAlphaNumeric(64);
        String message2 = randomAlphaNumeric(32);

        ChatMessageBuilder cmb1 = new ChatMessageBuilder();
        ChatMessageBuilder cmb2 = new ChatMessageBuilder();

        cmb1.append(message1);
        cmb2.append(message2);

        String c1 = cmb1.build();
        String c2 = cmb2.build();

        assertTrue(c1.equals(message1));
        assertTrue(c2.equals(message2));

    }

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
