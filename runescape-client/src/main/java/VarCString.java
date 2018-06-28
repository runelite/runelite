import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("VarCString")
public class VarCString extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   public static IndexDataBase field3283;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   public static NodeCache field3285;
   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "Lbk;"
   )
   @Export("mouseRecorder")
   static MouseRecorder mouseRecorder;
   @ObfuscatedName("q")
   public boolean field3284;

   static {
      field3285 = new NodeCache(64);
   }

   public VarCString() {
      this.field3284 = false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "597972575"
   )
   public void method4856(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4857(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-693004220"
   )
   void method4857(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3284 = true;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Liv;I)V",
      garbageValue = "1026887111"
   )
   public static void method4860(IndexDataBase var0) {
      class231.underlay_ref = var0;
   }
}
