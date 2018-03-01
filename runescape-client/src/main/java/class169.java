import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public abstract class class169 {
   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "723083645"
   )
   public abstract boolean vmethod3383(int var1) throws IOException;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1228440200"
   )
   public abstract int vmethod3389() throws IOException;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1683920252"
   )
   public abstract int vmethod3381() throws IOException;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1694519349"
   )
   public abstract int vmethod3399(byte[] var1, int var2, int var3) throws IOException;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "572887195"
   )
   public abstract void vmethod3387(byte[] var1, int var2, int var3) throws IOException;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1035620035"
   )
   public abstract void vmethod3379();

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Ljd;",
      garbageValue = "1680004275"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isHollow) {
            var1.clipType = 0;
            var1.blocksProjectile = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }
}
