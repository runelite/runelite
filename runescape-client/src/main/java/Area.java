import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3300;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Lid;"
   )
   public static Area[] field3285;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("skeletonsIndex")
   public static NodeCache skeletonsIndex;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1488076803
   )
   public final int field3287;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -993020471
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 766711877
   )
   int field3289;
   @ObfuscatedName("e")
   @Export("name")
   public String name;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1524780187
   )
   public int field3292;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1549248241
   )
   public int field3284;
   @ObfuscatedName("n")
   public String[] field3293;
   @ObfuscatedName("u")
   public String field3291;
   @ObfuscatedName("t")
   int[] field3305;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1214140793
   )
   int field3296;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -444852659
   )
   int field3298;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1448371723
   )
   int field3295;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1025542915
   )
   int field3299;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public class257 field3294;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public class239 field3301;
   @ObfuscatedName("k")
   int[] field3302;
   @ObfuscatedName("c")
   byte[] field3286;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 693992411
   )
   public int field3304;

   static {
      skeletonsIndex = new NodeCache(256);
   }

   public Area(int var1) {
      this.spriteId = -1;
      this.field3289 = -1;
      this.field3284 = 0;
      this.field3293 = new String[5];
      this.field3296 = Integer.MAX_VALUE;
      this.field3298 = Integer.MAX_VALUE;
      this.field3295 = Integer.MIN_VALUE;
      this.field3299 = Integer.MIN_VALUE;
      this.field3294 = class257.field3545;
      this.field3301 = class239.field3268;
      this.field3304 = -1;
      this.field3287 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lfz;I)V",
      garbageValue = "1603377583"
   )
   public void method4365(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4364(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfz;II)V",
      garbageValue = "2139814428"
   )
   void method4364(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3264();
      } else if(var2 == 2) {
         this.field3289 = var1.method3264();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3292 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3284 = var1.readUnsignedByte();
      } else {
         int var3;
         if(var2 == 7) {
            var3 = var1.readUnsignedByte();
            if((var3 & 1) == 0) {
               ;
            }

            if((var3 & 2) == 2) {
               ;
            }
         } else if(var2 == 8) {
            var1.readUnsignedByte();
         } else if(var2 >= 10 && var2 <= 14) {
            this.field3293[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3305 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3305[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3302 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3302.length; ++var5) {
               this.field3302[var5] = var1.readInt();
            }

            this.field3286 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3286[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3291 = var1.readString();
            } else if(var2 == 18) {
               var1.method3264();
            } else if(var2 == 19) {
               this.field3304 = var1.readUnsignedShort();
            } else if(var2 == 21) {
               var1.readInt();
            } else if(var2 == 22) {
               var1.readInt();
            } else if(var2 == 23) {
               var1.readUnsignedByte();
               var1.readUnsignedByte();
               var1.readUnsignedByte();
            } else if(var2 == 24) {
               var1.readShort();
               var1.readShort();
            } else if(var2 == 25) {
               var1.method3264();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               this.field3294 = (class257)class29.forOrdinal(class169.method3190(), var1.readUnsignedByte());
            } else if(var2 == 30) {
               this.field3301 = (class239)class29.forOrdinal(KeyFocusListener.method755(), var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   public void method4367() {
      if(this.field3305 != null) {
         for(int var1 = 0; var1 < this.field3305.length; var1 += 2) {
            if(this.field3305[var1] < this.field3296) {
               this.field3296 = this.field3305[var1];
            } else if(this.field3305[var1] > this.field3295) {
               this.field3295 = this.field3305[var1];
            }

            if(this.field3305[var1 + 1] < this.field3298) {
               this.field3298 = this.field3305[var1 + 1];
            } else if(this.field3305[var1 + 1] > this.field3299) {
               this.field3299 = this.field3305[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ZI)Lky;",
      garbageValue = "-536155849"
   )
   public SpritePixels method4368(boolean var1) {
      int var2 = this.spriteId;
      return this.method4380(var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lky;",
      garbageValue = "-910904890"
   )
   SpritePixels method4380(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)skeletonsIndex.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = BuildType.method4173(field3300, var1, 0);
            if(var2 != null) {
               skeletonsIndex.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method4381() {
      return this.field3287;
   }
}
