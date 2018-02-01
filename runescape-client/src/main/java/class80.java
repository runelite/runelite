import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
public class class80 {
   @ObfuscatedName("w")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("s")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("j")
   static int[] field1221;
   @ObfuscatedName("a")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("t")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1297520065
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("m")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1180815097
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Lbz;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("n")
   static Calendar field1228;
   @ObfuscatedName("y")
   static final String[] field1229;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 413093787
   )
   static int field1227;
   @ObfuscatedName("fn")
   @Export("xteaKeys")
   static int[][] xteaKeys;

   static {
      field1221 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1228 = Calendar.getInstance();
      field1229 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1227 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-260739952"
   )
   public static String method1781(CharSequence var0) {
      int var2 = var0.length();
      char[] var3 = new char[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = '*';
      }

      String var1 = new String(var3);
      return var1;
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-16845"
   )
   static void method1775(int var0) {
      Client.field1020 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      if(World.method1644() == 1) {
         class37.clientInstance.method824(765, 503);
      } else {
         class37.clientInstance.method824(7680, 2160);
      }

      if(Client.gameState >= 25) {
         class237.method4338();
      }

   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1872719176"
   )
   static void method1795(int var0, int var1) {
      PacketNode var2 = class35.method501(ClientPacket.field2308, Client.field867.field1439);
      var2.packetBuffer.writeIntLE(var0);
      var2.packetBuffer.writeShortLE(var1);
      Client.field867.method2021(var2);
   }
}
