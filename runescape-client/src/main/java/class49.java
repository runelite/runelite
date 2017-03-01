import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class49 extends Renderable {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1954534479
   )
   int field963;
   @ObfuscatedName("j")
   Sequence field964;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1342081263
   )
   int field965;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 234101623
   )
   int field966;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2021275491
   )
   int field967;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 24295725
   )
   int field968;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 476255781
   )
   int field969;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -39599043
   )
   int field970;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 144535
   )
   int field973;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 30500191
   )
   static int field974;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "1"
   )
   protected final Model getModel() {
      if(null != this.field964) {
         int var12 = Client.gameCycle - this.field973;
         if(var12 > 100 && this.field964.frameStep > 0) {
            var12 = 100;
         }

         label64: {
            do {
               do {
                  if(var12 <= this.field964.frameLenghts[this.field969]) {
                     break label64;
                  }

                  var12 -= this.field964.frameLenghts[this.field969];
                  ++this.field969;
               } while(this.field969 < this.field964.frameIDs.length);

               this.field969 -= this.field964.frameStep;
            } while(this.field969 >= 0 && this.field969 < this.field964.frameIDs.length);

            this.field964 = null;
         }

         this.field973 = Client.gameCycle - var12;
      }

      ObjectComposition var1 = ChatMessages.getObjectDefinition(this.field966);
      if(var1.impostorIds != null) {
         var1 = var1.getImpostor();
      }

      if(var1 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field970 != 1 && this.field970 != 3) {
            var2 = var1.sizeX;
            var3 = var1.sizeY;
         } else {
            var2 = var1.sizeY;
            var3 = var1.sizeX;
         }

         int var4 = this.field968 + (var2 >> 1);
         int var5 = (var2 + 1 >> 1) + this.field968;
         int var6 = (var3 >> 1) + this.field967;
         int var7 = this.field967 + (1 + var3 >> 1);
         int[][] var8 = class10.tileHeights[this.field965];
         int var9 = var8[var5][var6] + var8[var4][var6] + var8[var4][var7] + var8[var5][var7] >> 2;
         int var10 = (var2 << 6) + (this.field968 << 7);
         int var11 = (var3 << 6) + (this.field967 << 7);
         return var1.method3668(this.field963, this.field970, var8, var10, var9, var11, this.field964, this.field969);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;S)Z",
      garbageValue = "-10305"
   )
   public static boolean method976(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class114.field1786.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var10.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Object var3 = class100.method2040(class114.field1787, var2, new Object[]{(new URL(class114.field1787.getCodeBase(), var0)).toString()});
            return null != var3;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class114.field1787.getAppletContext().showDocument(new URL(class114.field1787.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class100.method2039(class114.field1787, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class114.field1787.getAppletContext().showDocument(new URL(class114.field1787.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   class49(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field966 = var1;
      this.field963 = var2;
      this.field970 = var3;
      this.field965 = var4;
      this.field968 = var5;
      this.field967 = var6;
      if(var7 != -1) {
         this.field964 = TextureProvider.getAnimation(var7);
         this.field969 = 0;
         this.field973 = Client.gameCycle - 1;
         if(this.field964.replyMode == 0 && var9 != null && var9 instanceof class49) {
            class49 var10 = (class49)var9;
            if(this.field964 == var10.field964) {
               this.field969 = var10.field969;
               this.field973 = var10.field973;
               return;
            }
         }

         if(var8 && this.field964.frameStep != -1) {
            this.field969 = (int)(Math.random() * (double)this.field964.frameIDs.length);
            this.field973 -= (int)(Math.random() * (double)this.field964.frameLenghts[this.field969]);
         }
      }

   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2048200619"
   )
   static void method979(int var0) {
      class15.field157 = new class38();
      class15.field157.field795 = Client.menuActionParams0[var0];
      class15.field157.field791 = Client.menuActionParams1[var0];
      class15.field157.field792 = Client.menuTypes[var0];
      class15.field157.field798 = Client.menuIdentifiers[var0];
      class15.field157.field794 = Client.menuOptions[var0];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;III)LFont;",
      garbageValue = "-1186845258"
   )
   public static Font method980(class182 var0, class182 var1, int var2, int var3) {
      if(!class137.method2556(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.getConfigData(var2, var3);
         Font var4;
         if(null == var5) {
            var4 = null;
         } else {
            Font var6 = new Font(var5, class225.field3236, class145.field2013, class186.field2775, class225.field3235, class225.field3237, Ignore.field211);
            WallObject.method1986();
            var4 = var6;
         }

         return var4;
      }
   }
}
