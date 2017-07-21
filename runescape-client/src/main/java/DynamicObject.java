import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("de")
   @Export("host")
   static String host;
   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   static IndexedSprite[] field1519;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   Sequence field1515;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 914135687
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1551842041
   )
   int field1517;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2020788553
   )
   @Export("type")
   int type;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1611585849
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 770085083
   )
   @Export("level")
   int level;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 507323569
   )
   int field1510;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -96751703
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1287456043
   )
   @Export("sceneY")
   int sceneY;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLev;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1515 = class31.getAnimation(var7);
         this.field1510 = 0;
         this.field1517 = Client.gameCycle - 1;
         if(this.field1515.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(var10.field1515 == this.field1515) {
               this.field1510 = var10.field1510;
               this.field1517 = var10.field1517;
               return;
            }
         }

         if(var8 && this.field1515.frameStep != -1) {
            this.field1510 = (int)(Math.random() * (double)this.field1515.frameIDs.length);
            this.field1517 -= (int)(Math.random() * (double)this.field1515.frameLenghts[this.field1510]);
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Leo;",
      garbageValue = "1"
   )
   protected final Model getModel() {
      if(this.field1515 != null) {
         int var1 = Client.gameCycle - this.field1517;
         if(var1 > 100 && this.field1515.frameStep > 0) {
            var1 = 100;
         }

         label54: {
            do {
               do {
                  if(var1 <= this.field1515.frameLenghts[this.field1510]) {
                     break label54;
                  }

                  var1 -= this.field1515.frameLenghts[this.field1510];
                  ++this.field1510;
               } while(this.field1510 < this.field1515.frameIDs.length);

               this.field1510 -= this.field1515.frameStep;
            } while(this.field1510 >= 0 && this.field1510 < this.field1515.frameIDs.length);

            this.field1515 = null;
         }

         this.field1517 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class169.getObjectDefinition(this.id);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.orientation != 1 && this.orientation != 3) {
            var2 = var12.sizeX;
            var3 = var12.sizeY;
         } else {
            var2 = var12.sizeY;
            var3 = var12.sizeX;
         }

         int var4 = this.sceneX + (var2 >> 1);
         int var5 = (var2 + 1 >> 1) + this.sceneX;
         int var6 = this.sceneY + (var3 >> 1);
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class61.tileHeights[this.level];
         int var9 = var8[var5][var6] + var8[var4][var6] + var8[var4][var7] + var8[var5][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method4405(this.type, this.orientation, var8, var10, var9, var11, this.field1515, this.field1510);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-843238825"
   )
   @Export("getString")
   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class266.field3645[var6 - 128];
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

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Ldk;I)V",
      garbageValue = "-958036567"
   )
   static final void method1789(class119 var0) {
      var0.field1681 = false;
      if(var0.field1682 != null) {
         var0.field1682.field1714 = 0;
      }

      for(class119 var1 = var0.vmethod3823(); var1 != null; var1 = var0.vmethod3835()) {
         method1789(var1);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "830467629"
   )
   static void method1790(File var0) {
      class157.field2216 = var0;
      if(!class157.field2216.exists()) {
         throw new RuntimeException("");
      } else {
         class157.field2220 = true;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   public static int method1791() {
      return KeyFocusListener.keyboardIdleTicks;
   }
}
