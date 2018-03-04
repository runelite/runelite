import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1171206149
   )
   @Export("id")
   int id;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -969538963
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1869269987
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 603726901
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1699494029
   )
   @Export("height")
   int height;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 158655981
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1016454269
   )
   @Export("startMovementCycle")
   int startMovementCycle;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 493686097
   )
   @Export("endCycle")
   int endCycle;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -724620829
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1627938643
   )
   @Export("startHeight")
   int startHeight;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1574219863
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("h")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("t")
   @Export("x")
   double x;
   @ObfuscatedName("i")
   @Export("y")
   double y;
   @ObfuscatedName("u")
   @Export("z")
   double z;
   @ObfuscatedName("q")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("v")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("f")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("b")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("c")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1039186975
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1694520419
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 298556511
   )
   @Export("int7")
   int int7;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -313287887
   )
   @Export("int6")
   int int6;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.int7 = 0;
      this.int6 = 0;
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.height = var5;
      this.startMovementCycle = var6;
      this.endCycle = var7;
      this.slope = var8;
      this.startHeight = var9;
      this.interacting = var10;
      this.endHeight = var11;
      this.isMoving = false;
      int var12 = class55.getSpotAnimType(this.id).field3484;
      if(var12 != -1) {
         this.animationSequence = class270.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1811146598"
   )
   @Export("moveProjectile")
   @Hook("projectileMoved")
   final void moveProjectile(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.x1 + (double)this.startHeight * var5 / var9;
         this.y = (double)this.y1 + (double)this.startHeight * var7 / var9;
         this.z = (double)this.height;
      }

      var5 = (double)(this.endCycle + 1 - var4);
      this.velocityX = ((double)var1 - this.x) / var5;
      this.velocityY = ((double)var2 - this.y) / var5;
      this.scalar = Math.sqrt(this.velocityX * this.velocityX + this.velocityY * this.velocityY);
      if(!this.isMoving) {
         this.velocityZ = -this.scalar * Math.tan((double)this.slope * 0.02454369D);
      }

      this.heightOffset = 2.0D * ((double)var3 - this.z - var5 * this.velocityZ) / (var5 * var5);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-127"
   )
   @Export("update")
   final void update(int var1) {
      this.isMoving = true;
      this.x += this.velocityX * (double)var1;
      this.y += this.velocityY * (double)var1;
      this.z += this.velocityZ * (double)var1 + (double)var1 * this.heightOffset * 0.5D * (double)var1;
      this.velocityZ += (double)var1 * this.heightOffset;
      this.rotationX = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityZ, this.scalar) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.int6 += var1;

         while(true) {
            do {
               do {
                  if(this.int6 <= this.animationSequence.frameLenghts[this.int7]) {
                     return;
                  }

                  this.int6 -= this.animationSequence.frameLenghts[this.int7];
                  ++this.int7;
               } while(this.int7 < this.animationSequence.frameIDs.length);

               this.int7 -= this.animationSequence.frameStep;
            } while(this.int7 >= 0 && this.int7 < this.animationSequence.frameIDs.length);

            this.int7 = 0;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lel;",
      garbageValue = "2099798459"
   )
   protected final Model getModel() {
      Spotanim var1 = class55.getSpotAnimType(this.id);
      Model var2 = var1.getModel(this.int7);
      if(var2 == null) {
         return null;
      } else {
         var2.rotateZ(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1737648066"
   )
   static int method1956(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var2.itemIds[var4] == var1) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1431597772"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class95.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class95.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class95.messages.put(var5, (long)var5.id);
      class95.field1431.add(var5);
      Client.chatCycle = Client.cycleCntr;
   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "51"
   )
   static boolean method1955() {
      return (Client.field988 & 8) != 0;
   }
}
