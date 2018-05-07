import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   public static IndexDataBase field3526;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static IndexDataBase field3523;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   public static NodeCache field3524;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static NodeCache field3525;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1729527485
   )
   public int field3535;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1864141589
   )
   public int field3528;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 349276191
   )
   public int field3529;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1901296485
   )
   public int field3530;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 896162011
   )
   public int field3534;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1544330417
   )
   public int field3532;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1614803455
   )
   int field3533;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1025931849
   )
   int field3531;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1734542527
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 83504381
   )
   public int field3536;

   static {
      field3524 = new NodeCache(64);
      field3525 = new NodeCache(64);
   }

   public CombatInfo2() {
      this.field3528 = 255;
      this.field3529 = 255;
      this.field3530 = -1;
      this.field3534 = 1;
      this.field3532 = 70;
      this.field3533 = -1;
      this.field3531 = -1;
      this.healthScale = 30;
      this.field3536 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgg;I)V",
      garbageValue = "1570389014"
   )
   @Export("read")
   public void read(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgg;IB)V",
      garbageValue = "-46"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3528 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3529 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3530 = 0;
      } else if(var2 == 5) {
         this.field3532 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3533 = var1.method3614();
      } else if(var2 == 8) {
         this.field3531 = var1.method3614();
      } else if(var2 == 11) {
         this.field3530 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3536 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Llv;",
      garbageValue = "73"
   )
   public SpritePixels method4958() {
      if(this.field3533 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3525.get((long)this.field3533);
         if(var1 != null) {
            return var1;
         } else {
            var1 = AbstractByteBuffer.getSpriteAsSpritePixels(field3523, this.field3533, 0);
            if(var1 != null) {
               field3525.put(var1, (long)this.field3533);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Llv;",
      garbageValue = "33"
   )
   public SpritePixels method4959() {
      if(this.field3531 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3525.get((long)this.field3531);
         if(var1 != null) {
            return var1;
         } else {
            var1 = AbstractByteBuffer.getSpriteAsSpritePixels(field3523, this.field3531, 0);
            if(var1 != null) {
               field3525.put(var1, (long)this.field3531);
            }

            return var1;
         }
      }
   }
}
