import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jv")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   public static IndexDataBase field3329;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   public static IndexDataBase field3322;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   public static NodeCache field3323;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   public static NodeCache field3324;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1972548595
   )
   public int field3325;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1255114555
   )
   public int field3326;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 248263857
   )
   public int field3327;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2080656795
   )
   public int field3328;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1915308625
   )
   public int field3321;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -443880531
   )
   public int field3330;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 532896571
   )
   int field3331;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1168450783
   )
   int field3332;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 256184477
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1793094733
   )
   public int field3334;

   static {
      field3323 = new NodeCache(64);
      field3324 = new NodeCache(64);
   }

   CombatInfo2() {
      this.field3326 = 255;
      this.field3327 = 255;
      this.field3328 = -1;
      this.field3321 = 1;
      this.field3330 = 70;
      this.field3331 = -1;
      this.field3332 = -1;
      this.healthScale = 30;
      this.field3334 = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "777133345"
   )
   @Export("read")
   void read(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "1316496871"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3326 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3327 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3328 = 0;
      } else if(var2 == 5) {
         this.field3330 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3331 = var1.method3585();
      } else if(var2 == 8) {
         this.field3332 = var1.method3585();
      } else if(var2 == 11) {
         this.field3328 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3334 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Llc;",
      garbageValue = "0"
   )
   public SpritePixels method4928() {
      if(this.field3331 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3324.get((long)this.field3331);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ChatLineBuffer.getSpriteAsSpritePixels(field3322, this.field3331, 0);
            if(var1 != null) {
               field3324.put(var1, (long)this.field3331);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Llc;",
      garbageValue = "-1620214021"
   )
   public SpritePixels method4929() {
      if(this.field3332 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3324.get((long)this.field3332);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ChatLineBuffer.getSpriteAsSpritePixels(field3322, this.field3332, 0);
            if(var1 != null) {
               field3324.put(var1, (long)this.field3332);
            }

            return var1;
         }
      }
   }
}
