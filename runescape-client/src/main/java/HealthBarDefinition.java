import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("HealthBarDefinition")
public class HealthBarDefinition extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__ii_m")
   public static AbstractIndexCache __ii_m;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__ii_f")
   public static AbstractIndexCache __ii_f;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("HealthBarDefinition_cached")
   public static EvictingDualNodeHashTable HealthBarDefinition_cached;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("HealthBarDefinition_cachedSprites")
   static EvictingDualNodeHashTable HealthBarDefinition_cachedSprites;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = 1912123225
   )
   @Export("selectedItemSlot")
   static int selectedItemSlot;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1515955705
   )
   @Export("__o")
   public int __o;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 390656615
   )
   @Export("int1")
   public int int1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1890433231
   )
   @Export("int2")
   public int int2;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1180353973
   )
   @Export("int3")
   public int int3;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1956457117
   )
   @Export("int4")
   public int int4;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -642961053
   )
   @Export("int5")
   public int int5;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1310001257
   )
   @Export("spriteId1")
   int spriteId1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1707680631
   )
   @Export("spriteId2")
   int spriteId2;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -354704697
   )
   @Export("width")
   public int width;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 166567703
   )
   @Export("widthPadding")
   public int widthPadding;

   public HealthBarDefinition() {
      this.int1 = 255;
      this.int2 = 255;
      this.int3 = -1;
      this.int4 = 1;
      this.int5 = 70;
      this.spriteId1 = -1;
      this.spriteId2 = -1;
      this.width = 30;
      this.widthPadding = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "280763431"
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;IB)V",
      garbageValue = "10"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.__ag_302();
      } else if(var2 == 2) {
         this.int1 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.int2 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.int3 = 0;
      } else if(var2 == 5) {
         this.int5 = var1.__ag_302();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.spriteId1 = var1.__ap_310();
      } else if(var2 == 8) {
         this.spriteId2 = var1.__ap_310();
      } else if(var2 == 11) {
         this.int3 = var1.__ag_302();
      } else if(var2 == 14) {
         this.width = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.widthPadding = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Lln;",
      garbageValue = "-97"
   )
   @Export("getSprite1")
   public Sprite getSprite1() {
      if(this.spriteId1 < 0) {
         return null;
      } else {
         Sprite var1 = (Sprite)HealthBarDefinition_cachedSprites.get((long)this.spriteId1);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class322.readSprite(__ii_f, this.spriteId1, 0);
            if(var1 != null) {
               HealthBarDefinition_cachedSprites.put(var1, (long)this.spriteId1);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Lln;",
      garbageValue = "-17"
   )
   @Export("getSprite2")
   public Sprite getSprite2() {
      if(this.spriteId2 < 0) {
         return null;
      } else {
         Sprite var1 = (Sprite)HealthBarDefinition_cachedSprites.get((long)this.spriteId2);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class322.readSprite(__ii_f, this.spriteId2, 0);
            if(var1 != null) {
               HealthBarDefinition_cachedSprites.put(var1, (long)this.spriteId2);
            }

            return var1;
         }
      }
   }

   static {
      HealthBarDefinition_cached = new EvictingDualNodeHashTable(64);
      HealthBarDefinition_cachedSprites = new EvictingDualNodeHashTable(64);
   }
}
