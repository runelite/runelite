import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
public class class253 extends CacheableNode {
   @ObfuscatedName("h")
   public static NodeCache field3393;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 419255579
   )
   public int field3394;
   @ObfuscatedName("u")
   public char field3395;
   @ObfuscatedName("q")
   public char field3396;
   @ObfuscatedName("p")
   public int[] field3397;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1758338255
   )
   public int field3398;
   @ObfuscatedName("g")
   public String field3399;
   @ObfuscatedName("i")
   public static IndexDataBase field3400;
   @ObfuscatedName("l")
   public int[] field3401;
   @ObfuscatedName("a")
   public String[] field3402;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1062066290"
   )
   public void method4530(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4542(var1, var2);
      }
   }

   public class253() {
      this.field3399 = "null";
      this.field3394 = 0;
   }

   static {
      field3393 = new NodeCache(64);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1717303979"
   )
   void method4542(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3395 = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.field3396 = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3399 = var1.readString();
      } else if(var2 == 4) {
         this.field3398 = var1.readInt();
      } else {
         int var3;
         if(var2 == 5) {
            this.field3394 = var1.readUnsignedShort();
            this.field3397 = new int[this.field3394];
            this.field3402 = new String[this.field3394];

            for(var3 = 0; var3 < this.field3394; ++var3) {
               this.field3397[var3] = var1.readInt();
               this.field3402[var3] = var1.readString();
            }
         } else if(var2 == 6) {
            this.field3394 = var1.readUnsignedShort();
            this.field3397 = new int[this.field3394];
            this.field3401 = new int[this.field3394];

            for(var3 = 0; var3 < this.field3394; ++var3) {
               this.field3397[var3] = var1.readInt();
               this.field3401[var3] = var1.readInt();
            }
         }
      }

   }
}
