import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("ab")
   @Export("clientInstance")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static Client clientInstance;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1011626287
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1301973049
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1386096285
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("o")
   @Export("x")
   double x;
   @ObfuscatedName("b")
   double field1447;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 985903965
   )
   int field1455;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1648978151
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1515909057
   )
   int field1432;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -558203825
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("p")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("w")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -563862753
   )
   @Export("start")
   int start;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1641155967
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("u")
   @Export("z")
   double z;
   @ObfuscatedName("c")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("n")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -759507035
   )
   @Export("height")
   int height;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1712549403
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("k")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -717257829
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1509764235
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -581108479
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1489699761
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   @Export("animationSequence")
   Sequence animationSequence;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.field1455 = 0;
      this.field1432 = 0;
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.height = var5;
      this.startTime = var6;
      this.cycle = var7;
      this.slope = var8;
      this.start = var9;
      this.interacting = var10;
      this.endHeight = var11;
      this.isMoving = false;
      int var12 = class36.getSpotAnimType(this.id).field3309;
      if(var12 != -1) {
         this.animationSequence = class40.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lev;",
      garbageValue = "1458652918"
   )
   protected final Model getModel() {
      Spotanim var1 = class36.getSpotAnimType(this.id);
      Model var2 = var1.method4310(this.field1455);
      if(var2 == null) {
         return null;
      } else {
         var2.method2531(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1990039435"
   )
   final void method1774(int var1) {
      this.isMoving = true;
      this.x += this.field1447 * (double)var1;
      this.velocityZ += this.scalar * (double)var1;
      this.z += (double)var1 * 0.5D * this.heightOffset * (double)var1 + (double)var1 * this.velocityX;
      this.velocityX += this.heightOffset * (double)var1;
      this.rotationX = (int)(Math.atan2(this.field1447, this.scalar) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field1432 += var1;

         while(true) {
            do {
               do {
                  if(this.field1432 <= this.animationSequence.frameLenghts[this.field1455]) {
                     return;
                  }

                  this.field1432 -= this.animationSequence.frameLenghts[this.field1455];
                  ++this.field1455;
               } while(this.field1455 < this.animationSequence.frameIDs.length);

               this.field1455 -= this.animationSequence.frameStep;
            } while(this.field1455 >= 0 && this.field1455 < this.animationSequence.frameIDs.length);

            this.field1455 = 0;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-263552427"
   )
   final void method1765(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = (double)this.x1 + (double)this.start * var5 / var9;
         this.velocityZ = (double)this.start * var7 / var9 + (double)this.y1;
         this.z = (double)this.height;
      }

      var5 = (double)(this.cycle + 1 - var4);
      this.field1447 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field1447 * this.field1447 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.slope);
      }

      this.heightOffset = 2.0D * ((double)var3 - this.z - this.velocityX * var5) / (var5 * var5);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "115"
   )
   static void method1762() {
      FileOnDisk var0 = null;

      try {
         var0 = class41.getPreferencesFile("", Client.field1110.field3177, true);
         Buffer var1 = class170.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.close();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1787401306"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class98.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class98.field1494.put(var5, (long)var5.id);
      class98.field1495.method3678(var5);
      Client.chatCycle = Client.cycleCntr;
   }
}
