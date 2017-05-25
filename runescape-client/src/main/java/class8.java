import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public final class class8 extends class9 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -880899825
   )
   final int field240;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -939288799
   )
   final int field241;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -971863485
   )
   final int field242;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 391872609
   )
   final int field243;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 291226243
   )
   final int field244;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1666560366"
   )
   static final int method31(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = var2 / 2 + (var0 / 4 << 10) + (var1 / 32 << 7);
      return var3;
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "2110396897"
   )
   static String method33(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var7 = var0.indexOf("%" + var2);
               if(var7 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var7);
               int var6 = class71.method1124(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var7 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var3 = "";
            if(class204.field2533 != null) {
               var3 = class4.method9(class204.field2533.field2205);
               if(class204.field2533.field2211 != null) {
                  var3 = (String)class204.field2533.field2211;
               }
            }

            var0 = var0.substring(0, var2) + var3 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-971641827"
   )
   static final void method34() {
      if(Sequence.plane != Client.field1117) {
         Client.field1117 = Sequence.plane;
         class286.method5212(Sequence.plane);
      }

   }

   class8(int var1, int var2, int var3, int var4, int var5) {
      this.field241 = var1;
      this.field240 = var2;
      this.field244 = var3;
      this.field242 = var4;
      this.field243 = var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-911944324"
   )
   final void vmethod43() {
      Rasterizer2D.method5012(this.field241 + Rasterizer2D.field3749, Rasterizer2D.field3746 + this.field240, this.field244 - this.field241, this.field242 - this.field240, this.field243);
   }
}
