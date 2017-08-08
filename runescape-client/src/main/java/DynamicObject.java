import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   Sequence field1537;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1666201333
   )
   @Export("id")
   int id;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 271367341
   )
   int field1542;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -466822093
   )
   @Export("type")
   int type;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -810371835
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 561378935
   )
   @Export("level")
   int level;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 801868257
   )
   int field1541;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1363642317
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -807838663
   )
   @Export("sceneY")
   int sceneY;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLeg;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1537 = Ignore.getAnimation(var7);
         this.field1541 = 0;
         this.field1542 = Client.gameCycle - 1;
         if(this.field1537.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(var10.field1537 == this.field1537) {
               this.field1541 = var10.field1541;
               this.field1542 = var10.field1542;
               return;
            }
         }

         if(var8 && this.field1537.frameStep != -1) {
            this.field1541 = (int)(Math.random() * (double)this.field1537.frameIDs.length);
            this.field1542 -= (int)(Math.random() * (double)this.field1537.frameLenghts[this.field1541]);
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lew;",
      garbageValue = "-2113451941"
   )
   protected final Model getModel() {
      if(this.field1537 != null) {
         int var1 = Client.gameCycle - this.field1542;
         if(var1 > 100 && this.field1537.frameStep > 0) {
            var1 = 100;
         }

         label55: {
            do {
               do {
                  if(var1 <= this.field1537.frameLenghts[this.field1541]) {
                     break label55;
                  }

                  var1 -= this.field1537.frameLenghts[this.field1541];
                  ++this.field1541;
               } while(this.field1541 < this.field1537.frameIDs.length);

               this.field1541 -= this.field1537.frameStep;
            } while(this.field1541 >= 0 && this.field1541 < this.field1537.frameIDs.length);

            this.field1537 = null;
         }

         this.field1542 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = WorldMapType1.getObjectDefinition(this.id);
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
         int var5 = this.sceneX + (var2 + 1 >> 1);
         int var6 = (var3 >> 1) + this.sceneY;
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class61.tileHeights[this.level];
         int var9 = var8[var4][var6] + var8[var5][var6] + var8[var4][var7] + var8[var5][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method4540(this.type, this.orientation, var8, var10, var9, var11, this.field1537, this.field1541);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16711935"
   )
   static void method1899() {
      try {
         File var0 = new File(class33.userHome, "random.dat");
         int var2;
         if(var0.exists()) {
            class156.field2230 = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label38:
            for(int var4 = 0; var4 < class262.field3617.length; ++var4) {
               for(var2 = 0; var2 < class156.cacheLocations.length; ++var2) {
                  File var3 = new File(class156.cacheLocations[var2] + class262.field3617[var4] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class156.field2230 = new CacheFile(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label38;
                  }
               }
            }
         }

         if(class156.field2230 == null) {
            RandomAccessFile var1 = new RandomAccessFile(var0, "rw");
            var2 = var1.read();
            var1.seek(0L);
            var1.write(var2);
            var1.seek(0L);
            var1.close();
            class156.field2230 = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }
}
