import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public final class class61 {
   @ObfuscatedName("r")
   static final int[] field748;
   @ObfuscatedName("m")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("g")
   static int[][][] field750;
   @ObfuscatedName("t")
   @Export("underlayIds")
   static byte[][][] underlayIds;
   @ObfuscatedName("x")
   static final int[] field752;
   @ObfuscatedName("o")
   static int[] field753;
   @ObfuscatedName("w")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("l")
   static final int[] field756;
   @ObfuscatedName("h")
   static final int[] field757;
   @ObfuscatedName("d")
   static final int[] field758;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1845982515
   )
   static int field759;
   @ObfuscatedName("b")
   static final int[] field760;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -160916027
   )
   static int field761;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -349881597
   )
   static int field762;
   @ObfuscatedName("p")
   @Export("tileHeights")
   static int[][][] tileHeights;

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "47"
   )
   static void method979(Buffer var0, int var1) {
      byte[] var2 = var0.payload;
      if(Client.field943 == null) {
         Client.field943 = new byte[24];
      }

      class183.method3339(var2, var1, Client.field943, 0, 24);
      if(class155.field2256 != null) {
         try {
            class155.field2256.method2256(0L);
            class155.field2256.method2241(var0.payload, var1, 24);
         } catch (Exception var4) {
            ;
         }
      }

   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "-77"
   )
   static final boolean method1007(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field957 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1177.method3852(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1177.method3841(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1177.method3842(false);
         }

         if(var1 == 325) {
            Client.field1177.method3842(true);
         }

         if(var1 == 326) {
            Client.secretPacketBuffer1.putOpcode(222);
            Client.field1177.method3843(Client.secretPacketBuffer1);
            return true;
         } else {
            return false;
         }
      }
   }

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field759 = 99;
      field748 = new int[]{1, 2, 4, 8};
      field756 = new int[]{16, 32, 64, 128};
      field757 = new int[]{1, 0, -1, 0};
      field758 = new int[]{0, -1, 0, 1};
      field752 = new int[]{1, -1, -1, 1};
      field760 = new int[]{-1, -1, 1, 1};
      field761 = (int)(Math.random() * 17.0D) - 8;
      field762 = (int)(Math.random() * 33.0D) - 16;
   }
}
