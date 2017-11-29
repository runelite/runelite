import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
public class class259 extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   static IndexDataBase field3462;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   static NodeCache field3461;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("currentRequest")
   public static FileRequest currentRequest;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   IterableHashTable field3460;

   static {
      field3461 = new NodeCache(64);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2034035910"
   )
   void method4613() {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "16711680"
   )
   void method4615(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4630(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lfr;IB)V",
      garbageValue = "-58"
   )
   void method4630(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3460 = CacheFile.readStringIntParameters(var1, this.field3460);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-2160"
   )
   public int method4616(int var1, int var2) {
      return IndexData.method4372(this.field3460, var1, var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "95"
   )
   public String method4621(int var1, String var2) {
      return Occluder.method3016(this.field3460, var1, var2);
   }
}
