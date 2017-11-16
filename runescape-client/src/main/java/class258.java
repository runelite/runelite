import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
public class class258 extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field3438;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field3435;
   @ObfuscatedName("r")
   char field3440;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1783477771
   )
   public int field3436;
   @ObfuscatedName("x")
   public String field3437;
   @ObfuscatedName("f")
   boolean field3439;

   static {
      field3435 = new NodeCache(64);
   }

   class258() {
      this.field3439 = true;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1667763271"
   )
   void method4426() {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfs;B)V",
      garbageValue = "-10"
   )
   void method4427(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4430(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfs;II)V",
      garbageValue = "811269978"
   )
   void method4430(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3440 = Script.method1835(var1.readByte());
      } else if(var2 == 2) {
         this.field3436 = var1.readInt();
      } else if(var2 == 4) {
         this.field3439 = false;
      } else if(var2 == 5) {
         this.field3437 = var1.readString();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1032673812"
   )
   public boolean method4429() {
      return this.field3440 == 's';
   }
}
