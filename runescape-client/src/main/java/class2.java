import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class2 {
   @ObfuscatedName("w")
   String field23;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 1557603357978303779L
   )
   public final long field24;
   @ObfuscatedName("c")
   public final XGrandExchangeOffer field25;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1540700185
   )
   public final int field26;
   @ObfuscatedName("au")
   static class184 field27;
   @ObfuscatedName("d")
   String field28;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1654669236"
   )
   public String method23() {
      return this.field28;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1265269918"
   )
   public String method24() {
      return this.field23;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "339460234"
   )
   static int method29(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class32.field756[--class32.field752];
         var3 = World.method670(var4);
      } else {
         var3 = var2?class26.field624:class32.field754;
      }

      if(var0 == 1100) {
         class32.field752 -= 2;
         var3.scrollX = class32.field756[class32.field752];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class32.field756[1 + class32.field752];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         method36(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class32.field756[--class32.field752];
         method36(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2215 = class32.field756[--class32.field752] == 1;
         method36(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class32.field756[--class32.field752];
         method36(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2202 = class32.field756[--class32.field752];
         method36(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.textureId = class32.field756[--class32.field752];
         method36(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.field2300 = class32.field756[--class32.field752];
         method36(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2224 = class32.field756[--class32.field752] == 1;
         method36(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class32.field756[--class32.field752];
         method36(var3);
         return 1;
      } else if(var0 == 1109) {
         class32.field752 -= 6;
         var3.field2235 = class32.field756[class32.field752];
         var3.field2236 = class32.field756[1 + class32.field752];
         var3.rotationX = class32.field756[2 + class32.field752];
         var3.rotationZ = class32.field756[3 + class32.field752];
         var3.rotationY = class32.field756[class32.field752 + 4];
         var3.field2240 = class32.field756[class32.field752 + 5];
         method36(var3);
         return 1;
      } else {
         int var5;
         if(var0 == 1110) {
            var5 = class32.field756[--class32.field752];
            if(var5 != var3.field2233) {
               var3.field2233 = var5;
               var3.field2308 = 0;
               var3.field2213 = 0;
               method36(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2243 = class32.field756[--class32.field752] == 1;
            method36(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class32.scriptStringStack[--class9.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               method36(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class32.field756[--class32.field752];
            method36(var3);
            return 1;
         } else if(var0 == 1114) {
            class32.field752 -= 3;
            var3.field2249 = class32.field756[class32.field752];
            var3.field2250 = class32.field756[1 + class32.field752];
            var3.field2248 = class32.field756[2 + class32.field752];
            method36(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.field2251 = class32.field756[--class32.field752] == 1;
            method36(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class32.field756[--class32.field752];
            method36(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class32.field756[--class32.field752];
            method36(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class32.field756[--class32.field752] == 1;
            method36(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class32.field756[--class32.field752] == 1;
            method36(var3);
            return 1;
         } else if(var0 == 1120) {
            class32.field752 -= 2;
            var3.scrollWidth = class32.field756[class32.field752];
            var3.scrollHeight = class32.field756[1 + class32.field752];
            method36(var3);
            if(var4 != -1 && var3.type == 0) {
               class107.method2100(Widget.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            var5 = var3.id;
            int var6 = var3.index;
            Client.field309.method3076(171);
            Client.field309.method2864(var6);
            Client.field309.method2819(var5);
            Client.field477 = var3;
            method36(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2297 = class32.field756[--class32.field752];
            method36(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2212 = class32.field756[--class32.field752];
            method36(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2218 = class32.field756[--class32.field752];
            method36(var3);
            return 1;
         } else if(var0 == 1125) {
            var5 = class32.field756[--class32.field752];
            class221[] var9 = new class221[]{class221.field3203, class221.field3199, class221.field3201, class221.field3202, class221.field3204};
            class221 var7 = (class221)class5.method77(var9, var5);
            if(null != var7) {
               var3.field2194 = var7;
               method36(var3);
            }

            return 1;
         } else {
            return 2;
         }
      }
   }

   class2(Buffer var1, byte var2, int var3) {
      this.field28 = var1.readString();
      this.field23 = var1.readString();
      this.field26 = var1.readUnsignedShort();
      this.field24 = var1.method2837();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field25 = new XGrandExchangeOffer();
      this.field25.method52(2);
      this.field25.method53(var2);
      this.field25.price = var4;
      this.field25.totalQuantity = var5;
      this.field25.quantitySold = 0;
      this.field25.spent = 0;
      this.field25.itemId = var3;
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;I)V",
      garbageValue = "1751324449"
   )
   static final void method32(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle + Client.mapScale & 2047;
         int var8 = class84.field1441[var7];
         int var9 = class84.field1462[var7];
         var8 = 256 * var8 / (Client.mapScaleDelta + 256);
         var9 = 256 * var9 / (256 + Client.mapScaleDelta);
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         Frames.field1583.method4161(4 + var14 + 94 + var0 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class105.method2087(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)LFileOnDisk;",
      garbageValue = "-185334942"
   )
   public static FileOnDisk method33(String var0, String var1, boolean var2) {
      File var3 = new File(class217.field3183, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class18.field234 == 33) {
         var4 = "_rc";
      } else if(class18.field234 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class30.field724, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;B)I",
      garbageValue = "49"
   )
   public static int method34(byte[] var0, int var1, CharSequence var2) {
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

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1551253934"
   )
   static void method35(Widget var0, int var1, int var2) {
      if(var0.field2191 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2191 == 1) {
         var0.relativeX = (var1 - var0.width) / 2 + var0.originalX;
      } else if(var0.field2191 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2191 == 3) {
         var0.relativeX = var1 * var0.originalX >> 14;
      } else if(var0.field2191 == 4) {
         var0.relativeX = (var0.originalX * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var1 * var0.originalX >> 14);
      }

      if(var0.field2192 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2192 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.field2192 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2192 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2192 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var2 * var0.originalY >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field562 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.width + var0.relativeX > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "-92"
   )
   static void method36(Widget var0) {
      if(Client.field517 == var0.field2318) {
         Client.field518[var0.boundsIndex] = true;
      }

   }
}
