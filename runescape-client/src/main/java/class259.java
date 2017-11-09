import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
public class class259 extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field3447;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   public static NodeCache field3448;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   IterableHashTable field3449;

   static {
      field3448 = new NodeCache(64);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   public void method4644() {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfv;I)V",
      garbageValue = "2104852488"
   )
   public void method4637(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4633(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfv;IS)V",
      garbageValue = "24481"
   )
   void method4633(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3449 = Tile.method2607(var1, this.field3449);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-24"
   )
   public int method4634(int var1, int var2) {
      return Occluder.method2998(this.field3449, var1, var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "47"
   )
   public String method4640(int var1, String var2) {
      return VertexNormal.method2702(this.field3449, var1, var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILjj;II)V",
      garbageValue = "1102683789"
   )
   static void method4645(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class81 var5 = new class81();
      var5.field1244 = var0;
      var5.field1239 = var1 * 128;
      var5.field1240 = var2 * 128;
      int var6 = var3.sizeX;
      int var7 = var3.sizeY;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.sizeY;
         var7 = var3.sizeX;
      }

      var5.field1237 = (var6 + var1) * 128;
      var5.field1242 = (var7 + var2) * 128;
      var5.field1238 = var3.ambientSoundId;
      var5.field1241 = var3.field3511 * 128;
      var5.field1246 = var3.field3533;
      var5.field1247 = var3.field3534;
      var5.field1248 = var3.field3535;
      if(var3.impostorIds != null) {
         var5.field1251 = var3;
         var5.method1689();
      }

      class81.field1250.addFront(var5);
      if(var5.field1248 != null) {
         var5.field1249 = var5.field1246 + (int)(Math.random() * (double)(var5.field1247 - var5.field1246));
      }

   }
}
