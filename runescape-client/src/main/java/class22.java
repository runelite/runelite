import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class22 extends class28 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfv;Lfv;I)V",
      garbageValue = "1256447166"
   )
   void method178(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field479.field481) {
         throw new IllegalStateException("");
      } else {
         super.field395 = var2.readUnsignedByte();
         super.field391 = var2.readUnsignedByte();
         super.field399 = var2.readUnsignedShort();
         super.field392 = var2.readUnsignedShort();
         super.field393 = var2.readUnsignedShort();
         super.field394 = var2.readUnsignedShort();
         super.field391 = Math.min(super.field391, 4);
         super.field396 = new short[1][64][64];
         super.field397 = new short[super.field391][64][64];
         super.field398 = new byte[super.field391][64][64];
         super.field400 = new byte[super.field391][64][64];
         super.field401 = new class31[super.field391][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field472.field468) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field393 && var5 == super.field394) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method244(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public int hashCode() {
      return super.field393 | super.field394 << 8;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return super.field393 == var2.field393 && var2.field394 == super.field394;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lik;I)V",
      garbageValue = "-1949100792"
   )
   public static void method189(IndexDataBase var0) {
      class259.field3447 = var0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "-840702097"
   )
   static char method187(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2115735631"
   )
   public static int method186() {
      return KeyFocusListener.keyboardIdleTicks;
   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1162141264"
   )
   static final void method188() {
      int var0 = class188.field2532 * 128 + 64;
      int var1 = class18.field309 * 128 + 64;
      int var2 = class70.getTileHeight(var0, var1, Ignore.plane) - class11.field265;
      if(class29.cameraX < var0) {
         class29.cameraX = (var0 - class29.cameraX) * class20.field325 / 1000 + class29.cameraX + class25.field358;
         if(class29.cameraX > var0) {
            class29.cameraX = var0;
         }
      }

      if(class29.cameraX > var0) {
         class29.cameraX -= class20.field325 * (class29.cameraX - var0) / 1000 + class25.field358;
         if(class29.cameraX < var0) {
            class29.cameraX = var0;
         }
      }

      if(class70.cameraZ < var2) {
         class70.cameraZ = (var2 - class70.cameraZ) * class20.field325 / 1000 + class70.cameraZ + class25.field358;
         if(class70.cameraZ > var2) {
            class70.cameraZ = var2;
         }
      }

      if(class70.cameraZ > var2) {
         class70.cameraZ -= class20.field325 * (class70.cameraZ - var2) / 1000 + class25.field358;
         if(class70.cameraZ < var2) {
            class70.cameraZ = var2;
         }
      }

      if(Player.cameraY < var1) {
         Player.cameraY = (var1 - Player.cameraY) * class20.field325 / 1000 + Player.cameraY + class25.field358;
         if(Player.cameraY > var1) {
            Player.cameraY = var1;
         }
      }

      if(Player.cameraY > var1) {
         Player.cameraY -= class20.field325 * (Player.cameraY - var1) / 1000 + class25.field358;
         if(Player.cameraY < var1) {
            Player.cameraY = var1;
         }
      }

      var0 = class34.field467 * 128 + 64;
      var1 = class64.field761 * 128 + 64;
      var2 = class70.getTileHeight(var0, var1, Ignore.plane) - CombatInfo1.field1207;
      int var3 = var0 - class29.cameraX;
      int var4 = var2 - class70.cameraZ;
      int var5 = var1 - Player.cameraY;
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class28.cameraPitch < var7) {
         class28.cameraPitch = (var7 - class28.cameraPitch) * class8.field238 / 1000 + class28.cameraPitch + TextureProvider.field1688;
         if(class28.cameraPitch > var7) {
            class28.cameraPitch = var7;
         }
      }

      if(class28.cameraPitch > var7) {
         class28.cameraPitch -= class8.field238 * (class28.cameraPitch - var7) / 1000 + TextureProvider.field1688;
         if(class28.cameraPitch < var7) {
            class28.cameraPitch = var7;
         }
      }

      int var9 = var8 - class228.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class228.cameraYaw = class228.cameraYaw + TextureProvider.field1688 + var9 * class8.field238 / 1000;
         class228.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         class228.cameraYaw -= TextureProvider.field1688 + -var9 * class8.field238 / 1000;
         class228.cameraYaw &= 2047;
      }

      int var10 = var8 - class228.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class228.cameraYaw = var8;
      }

   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "548248272"
   )
   static final void method180(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field980; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1055[var4] = true;
         }
      }

   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "([Lhk;Lhk;ZI)V",
      garbageValue = "-27709495"
   )
   static void method179(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      Timer.method3093(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         Timer.method3093(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(CombatInfoListHolder.loadWidget(var6)) {
            Timer.method3093(class243.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
