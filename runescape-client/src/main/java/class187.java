import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class187 extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 186956781
   )
   public int field2767 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1330078133
   )
   public static int field2768;
   @ObfuscatedName("i")
   public static NodeCache field2769 = new NodeCache(64);
   @ObfuscatedName("b")
   static class182 field2770;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      longValue = 7684826748558282163L
   )
   static long field2771;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;B)V",
      garbageValue = "92"
   )
   public static void method3501(class182 var0) {
      FloorUnderlayDefinition.field2815 = var0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "16384"
   )
   void method3502(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field2767 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-108"
   )
   void method3510(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3502(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "1281638134"
   )
   public static String method3514(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var1 + var5] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class203.field3081[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "47"
   )
   static String method3515(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }
}
