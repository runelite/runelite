import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public final class class29 {
   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   static class233 field424;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 432217385
   )
   @Export("myWorldPort")
   static int myWorldPort;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -1556499955
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   static class290 field422;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Laf;"
   )
   final class41 this$0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -683631399
   )
   int field418;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -923935995
   )
   int field420;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1578398573
   )
   int field428;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1941860129
   )
   int field417;

   @ObfuscatedSignature(
      signature = "(Laf;)V"
   )
   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "851695284"
   )
   public static int method248(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1635819020"
   )
   static final void method249(int var0) {
      int[] var1 = class56.field667.image;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = 24628 + (103 - var3) * 2048;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class61.tileSettings[var0][var5][var3] & 24) == 0) {
               class84.region.method2721(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               class84.region.method2721(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class56.field667.method5091();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class61.tileSettings[var0][var6][var5] & 24) == 0) {
               WorldMapType3.method202(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               WorldMapType3.method202(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field1132 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class84.region.method2739(plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = WorldMapType1.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  Client.field1075[Client.field1132] = Area.field3276[var8].method4294(false);
                  Client.field1133[Client.field1132] = var5;
                  Client.field1134[Client.field1132] = var6;
                  ++Client.field1132;
               }
            }
         }
      }

      class19.field322.setRaster();
   }
}
