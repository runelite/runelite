import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class8 {
   @ObfuscatedName("ey")
   static SpritePixels field73;
   @ObfuscatedName("py")
   static GarbageCollectorMXBean field77;
   @ObfuscatedName("qm")
   protected static class109 field79;
   @ObfuscatedName("t")
   static ModIcon field80;

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;I)V",
      garbageValue = "-168986593"
   )
   static void method111(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = class157.method3011(var1, var2);
      if(null != var5) {
         if(var5.field2285 != null) {
            class18 var6 = new class18();
            var6.field195 = var5;
            var6.field192 = var0;
            var6.field197 = var4;
            var6.field203 = var5.field2285;
            class49.method871(var6, 200000);
         }

         boolean var7 = true;
         if(var5.contentType > 0) {
            var7 = class2.method26(var5);
         }

         if(var7 && Friend.method177(GameObject.method1872(var5), var0 - 1)) {
            if(var0 == 1) {
               Client.field326.method3029(109);
               Client.field326.method2763(var1);
               Client.field326.method2918(var2);
               Client.field326.method2918(var3);
            }

            if(var0 == 2) {
               Client.field326.method3029(37);
               Client.field326.method2763(var1);
               Client.field326.method2918(var2);
               Client.field326.method2918(var3);
            }

            if(var0 == 3) {
               Client.field326.method3029(213);
               Client.field326.method2763(var1);
               Client.field326.method2918(var2);
               Client.field326.method2918(var3);
            }

            if(var0 == 4) {
               Client.field326.method3029(77);
               Client.field326.method2763(var1);
               Client.field326.method2918(var2);
               Client.field326.method2918(var3);
            }

            if(var0 == 5) {
               Client.field326.method3029(215);
               Client.field326.method2763(var1);
               Client.field326.method2918(var2);
               Client.field326.method2918(var3);
            }

            if(var0 == 6) {
               Client.field326.method3029(176);
               Client.field326.method2763(var1);
               Client.field326.method2918(var2);
               Client.field326.method2918(var3);
            }

            if(var0 == 7) {
               Client.field326.method3029(96);
               Client.field326.method2763(var1);
               Client.field326.method2918(var2);
               Client.field326.method2918(var3);
            }

            if(var0 == 8) {
               Client.field326.method3029(142);
               Client.field326.method2763(var1);
               Client.field326.method2918(var2);
               Client.field326.method2918(var3);
            }

            if(var0 == 9) {
               Client.field326.method3029(102);
               Client.field326.method2763(var1);
               Client.field326.method2918(var2);
               Client.field326.method2918(var3);
            }

            if(var0 == 10) {
               Client.field326.method3029(68);
               Client.field326.method2763(var1);
               Client.field326.method2918(var2);
               Client.field326.method2918(var3);
            }
         }
      }

   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "922893632"
   )
   static final String[] method112(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(null != var0 && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-78"
   )
   static final byte[] method113(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.method2780();
      if(var3 < 0 || class182.field2696 != 0 && var3 > class182.field2696) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var6 = new byte[var3];
         var1.method2974(var6, 0, var3);
         return var6;
      } else {
         int var4 = var1.method2780();
         if(var4 < 0 || class182.field2696 != 0 && var4 > class182.field2696) {
            throw new RuntimeException();
         } else {
            byte[] var5 = new byte[var4];
            if(var2 == 1) {
               class147.method2720(var5, var4, var0, var3, 9);
            } else {
               class182.field2694.method2713(var1, var5);
            }

            return var5;
         }
      }
   }
}
