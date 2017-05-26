import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class45 extends class28 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1310996309
   )
   int field580;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -742839611
   )
   int field581;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1684299879
   )
   int field582;
   @ObfuscatedName("ab")
   static class231 field583;
   @ObfuscatedName("bz")
   static ModIcon[] field584;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -242173557
   )
   int field585;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;LBuffer;B)V",
      garbageValue = "29"
   )
   void method652(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(class36.field498.field499 != var3) {
         throw new IllegalStateException("");
      } else {
         super.field410 = var2.readUnsignedByte();
         super.field408 = var2.readUnsignedByte();
         super.field409 = var2.readUnsignedShort();
         super.field404 = var2.readUnsignedShort();
         this.field585 = var2.readUnsignedByte();
         this.field580 = var2.readUnsignedByte();
         super.field407 = var2.readUnsignedShort();
         super.field406 = var2.readUnsignedShort();
         this.field581 = var2.readUnsignedByte();
         this.field582 = var2.readUnsignedByte();
         super.field408 = Math.min(super.field408, 4);
         super.field405 = new short[1][64][64];
         super.field403 = new short[super.field408][64][64];
         super.field411 = new byte[super.field408][64][64];
         super.field412 = new byte[super.field408][64][64];
         super.field413 = new class31[super.field408][64][64][];
         var3 = var1.readUnsignedByte();
         if(class35.field490.field489 != var3) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(super.field407 == var4 && super.field406 == var5 && var6 == this.field581 && var7 == this.field582) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method219(var8 + this.field581 * 8, this.field582 * 8 + var9, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public int hashCode() {
      return super.field407 | super.field406 << 8 | this.field581 << 16 | this.field582 << 24;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return var2.field407 == super.field407 && var2.field406 == super.field406?var2.field581 == this.field581 && var2.field582 == this.field582:false;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-38"
   )
   int method654() {
      return this.field585;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "84715568"
   )
   int method655() {
      return this.field580;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "96935245"
   )
   int method656() {
      return this.field581;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-701304195"
   )
   int method657() {
      return this.field582;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "-1201561886"
   )
   public static int method660(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1759687363"
   )
   boolean method673(int var1, int var2) {
      return var1 < this.field581 * 8?false:(var2 < this.field582 * 8?false:(var1 >= this.field581 * 8 + 8?false:var2 < this.field582 * 8 + 8));
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass210;B)V",
      garbageValue = "0"
   )
   static final void method675(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle + Client.mapScale & 2047;
         int var8 = class136.SINE[var7];
         int var9 = class136.COSINE[var7];
         var8 = var8 * 256 / (Client.mapScaleDelta + 256);
         var9 = var9 * 256 / (Client.mapScaleDelta + 256);
         int var10 = var3 * var8 + var9 * var2 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class158.field2238.method5144(var0 + 94 + var14 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class54.method787(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   static final void method676(int var0) {
      class18.method132();
      Preferences.method1591();
      int var1 = XItemContainer.method1091(var0).field3272;
      if(var1 != 0) {
         int var2 = class211.widgetSettings[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class136.method2627(0.9D);
               ((TextureProvider)class136.field2017).method2437(0.9D);
            }

            if(var2 == 2) {
               class136.method2627(0.8D);
               ((TextureProvider)class136.field2017).method2437(0.8D);
            }

            if(var2 == 3) {
               class136.method2627(0.7D);
               ((TextureProvider)class136.field2017).method2437(0.7D);
            }

            if(var2 == 4) {
               class136.method2627(0.6D);
               ((TextureProvider)class136.field2017).method2437(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(Client.field1077 != var3) {
               if(Client.field1077 == 0 && Client.field1127 != -1) {
                  class32.method322(class44.indexTrack1, Client.field1127, 0, var3, false);
                  Client.field1109 = false;
               } else if(var3 == 0) {
                  class36.field501.method3801();
                  class203.field2498 = 1;
                  Varbit.field3380 = null;
                  Client.field1109 = false;
               } else {
                  class7.method27(var3);
               }

               Client.field1077 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field1129 = 127;
            }

            if(var2 == 1) {
               Client.field1129 = 96;
            }

            if(var2 == 2) {
               Client.field1129 = 64;
            }

            if(var2 == 3) {
               Client.field1129 = 32;
            }

            if(var2 == 4) {
               Client.field1129 = 0;
            }
         }

         if(var1 == 5) {
            Client.field1027 = var2;
         }

         if(var1 == 6) {
            Client.field1052 = var2;
         }

         if(var1 == 9) {
            Client.field1069 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field1130 = 127;
            }

            if(var2 == 1) {
               Client.field1130 = 96;
            }

            if(var2 == 2) {
               Client.field1130 = 64;
            }

            if(var2 == 3) {
               Client.field1130 = 32;
            }

            if(var2 == 4) {
               Client.field1130 = 0;
            }
         }

         if(var1 == 17) {
            Client.field1058 = var2 & '\uffff';
         }

         if(var1 == 18) {
            Client.field915 = (class91)Client.method1381(RSCanvas.method784(), var2);
            if(Client.field915 == null) {
               Client.field915 = class91.field1410;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field1106 = -1;
            } else {
               Client.field1106 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            Client.field916 = (class91)Client.method1381(RSCanvas.method784(), var2);
            if(Client.field916 == null) {
               Client.field916 = class91.field1410;
            }
         }

      }
   }
}
