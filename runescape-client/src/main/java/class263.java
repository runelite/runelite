import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
public class class263 extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field3455;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   public static NodeCache field3453;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1653424239
   )
   @Export("canvasHeight")
   protected static int canvasHeight;
   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   @Export("slStarSprites")
   static IndexedSprite[] slStarSprites;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   IterableHashTable field3454;

   static {
      field3453 = new NodeCache(64);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16776960"
   )
   public void method4713() {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "-1975218954"
   )
   public void method4709(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4710(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgj;II)V",
      garbageValue = "1978695196"
   )
   void method4710(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3454 = Widget.readStringIntParameters(var1, this.field3454);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1799174280"
   )
   public int method4711(int var1, int var2) {
      return CollisionData.method3283(this.field3454, var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1574168581"
   )
   public String method4712(int var1, String var2) {
      return MessageNode.method1088(this.field3454, var1, var2);
   }
}
