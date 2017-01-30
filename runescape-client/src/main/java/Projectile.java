import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1782584813
   )
   int field854;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1261873713
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1655501953
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1676886003
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1706214019
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 53502491
   )
   int field859;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1041110347
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1348365305
   )
   int field861;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1887483175
   )
   int field862;
   @ObfuscatedName("z")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1413025057
   )
   @Export("start")
   int start;
   @ObfuscatedName("m")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("h")
   @Export("x")
   double x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2256983
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("i")
   double field869;
   @ObfuscatedName("r")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("n")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("w")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("y")
   @Export("az")
   double az;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 7111249
   )
   @Export("id")
   int id;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 318742963
   )
   int field875;
   @ObfuscatedName("u")
   @Export("z")
   double z;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = 1811150155
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("l")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1462804465
   )
   int field879 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1964847313
   )
   int field880 = 0;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1932266224"
   )
   final void method774(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = var5 * (double)this.start / var9 + (double)this.x1;
         this.velocityZ = var7 * (double)this.start / var9 + (double)this.y1;
         this.z = (double)this.z1;
      }

      var5 = (double)(1 + this.field861 - var4);
      this.field869 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.scalar * this.scalar + this.field869 * this.field869);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.field862 * 0.02454369D);
      }

      this.az = 2.0D * ((double)var3 - this.z - this.velocityX * var5) / (var5 * var5);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-1"
   )
   final void method775(int var1) {
      this.isMoving = true;
      this.x += this.field869 * (double)var1;
      this.velocityZ += this.scalar * (double)var1;
      this.z += (double)var1 * (double)var1 * 0.5D * this.az + (double)var1 * this.velocityX;
      this.velocityX += this.az * (double)var1;
      this.field854 = (int)(Math.atan2(this.field869, this.scalar) * 325.949D) + 1024 & 2047;
      this.field875 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(null != this.animationSequence) {
         this.field879 += var1;

         while(true) {
            do {
               do {
                  if(this.field879 <= this.animationSequence.frameLenghts[this.field880]) {
                     return;
                  }

                  this.field879 -= this.animationSequence.frameLenghts[this.field880];
                  ++this.field880;
               } while(this.field880 < this.animationSequence.frameIDs.length);

               this.field880 -= this.animationSequence.frameStep;
            } while(this.field880 >= 0 && this.field880 < this.animationSequence.frameIDs.length);

            this.field880 = 0;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2063755858"
   )
   protected final Model getModel() {
      Spotanim var1 = TextureProvider.method1452(this.id);
      Model var2 = var1.method3456(this.field880);
      if(var2 == null) {
         return null;
      } else {
         var2.method1567(this.field875);
         return var2;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1401146166"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class47.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method891(var0, var1, var2, var3);
      class47.field928.method2326(var5, (long)var5.id);
      class47.field929.method2479(var5);
      Client.field469 = Client.field462;
   }

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field861 = var7;
      this.field862 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field859 = var11;
      this.isMoving = false;
      int var12 = TextureProvider.method1452(this.id).field2792;
      if(var12 != -1) {
         this.animationSequence = class146.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "862514775"
   )
   public static int method784(CharSequence var0, int var1) {
      return class206.method3819(var0, var1, true);
   }
}
