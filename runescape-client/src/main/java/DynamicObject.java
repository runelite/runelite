import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1075365621
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -86666889
   )
   @Export("type")
   int type;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1841293615
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -156840023
   )
   @Export("level")
   int level;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 45773791
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1127872755
   )
   @Export("sceneY")
   int sceneY;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   Sequence field1438;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1267006365
   )
   int field1439;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2100657835
   )
   int field1440;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLel;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1438 = Permission.getAnimation(var7);
         this.field1439 = 0;
         this.field1440 = Client.gameCycle - 1;
         if(this.field1438.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(this.field1438 == var10.field1438) {
               this.field1439 = var10.field1439;
               this.field1440 = var10.field1440;
               return;
            }
         }

         if(var8 && this.field1438.frameStep != -1) {
            this.field1439 = (int)(Math.random() * (double)this.field1438.frameIDs.length);
            this.field1440 -= (int)(Math.random() * (double)this.field1438.frameLenghts[this.field1439]);
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lef;",
      garbageValue = "620909653"
   )
   protected final Model getModel() {
      if(this.field1438 != null) {
         int var1 = Client.gameCycle - this.field1440;
         if(var1 > 100 && this.field1438.frameStep > 0) {
            var1 = 100;
         }

         label54: {
            do {
               do {
                  if(var1 <= this.field1438.frameLenghts[this.field1439]) {
                     break label54;
                  }

                  var1 -= this.field1438.frameLenghts[this.field1439];
                  ++this.field1439;
               } while(this.field1439 < this.field1438.frameIDs.length);

               this.field1439 -= this.field1438.frameStep;
            } while(this.field1439 >= 0 && this.field1439 < this.field1438.frameIDs.length);

            this.field1438 = null;
         }

         this.field1440 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = CacheFile.getObjectDefinition(this.id);
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

         int var4 = (var2 >> 1) + this.sceneX;
         int var5 = (var2 + 1 >> 1) + this.sceneX;
         int var6 = (var3 >> 1) + this.sceneY;
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class61.tileHeights[this.level];
         int var9 = var8[var4][var7] + var8[var5][var6] + var8[var4][var6] + var8[var5][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method4666(this.type, this.orientation, var8, var10, var9, var11, this.field1438, this.field1439);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Lda;",
      garbageValue = "-734480589"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class157.field2138, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(AbstractByteBuffer.field2534 == 33) {
         var4 = "_rc";
      } else if(AbstractByteBuffer.field2534 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class1.userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
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
}
