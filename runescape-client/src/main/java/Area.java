import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static IndexDataBase field3462;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1198736539
   )
   static int field3450;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   @Export("areaSpriteCache")
   static NodeCache areaSpriteCache;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 46502545
   )
   @Export("id")
   public final int id;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1270791187
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1909428591
   )
   int field3454;
   @ObfuscatedName("y")
   @Export("name")
   public String name;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1005977339
   )
   public int field3456;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2089453755
   )
   public int field3457;
   @ObfuscatedName("o")
   public String[] field3470;
   @ObfuscatedName("d")
   public String field3459;
   @ObfuscatedName("r")
   int[] field3461;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1929071353
   )
   int field3468;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 911448357
   )
   int field3466;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -402683479
   )
   int field3464;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1237841931
   )
   int field3465;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   @Export("horizontalAlignment")
   public HorizontalAlignment horizontalAlignment;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   @Export("verticalAlignment")
   public VerticalAlignment verticalAlignment;
   @ObfuscatedName("k")
   int[] field3449;
   @ObfuscatedName("w")
   byte[] field3469;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1677837203
   )
   public int field3463;

   static {
      areaSpriteCache = new NodeCache(256);
   }

   Area(int var1) {
      this.spriteId = -1;
      this.field3454 = -1;
      this.field3457 = 0;
      this.field3470 = new String[5];
      this.field3468 = Integer.MAX_VALUE;
      this.field3466 = Integer.MAX_VALUE;
      this.field3464 = Integer.MIN_VALUE;
      this.field3465 = Integer.MIN_VALUE;
      this.horizontalAlignment = HorizontalAlignment.field3704;
      this.verticalAlignment = VerticalAlignment.field3436;
      this.field3463 = -1;
      this.id = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgg;I)V",
      garbageValue = "-2074966051"
   )
   void method4869(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4862(var1, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgg;IB)V",
      garbageValue = "74"
   )
   void method4862(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3614();
      } else if(var2 == 2) {
         this.field3454 = var1.method3614();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3456 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3457 = var1.readUnsignedByte();
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
            this.field3470[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3461 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3461[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3449 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3449.length; ++var5) {
               this.field3449[var5] = var1.readInt();
            }

            this.field3469 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3469[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3459 = var1.readString();
            } else if(var2 == 18) {
               var1.method3614();
            } else if(var2 == 19) {
               this.field3463 = var1.readUnsignedShort();
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
               var1.method3614();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               this.horizontalAlignment = (HorizontalAlignment)class185.forOrdinal(WorldMapDecoration.method277(), var1.readUnsignedByte());
            } else if(var2 == 30) {
               VerticalAlignment[] var6 = new VerticalAlignment[]{VerticalAlignment.field3437, VerticalAlignment.field3438, VerticalAlignment.field3436};
               this.verticalAlignment = (VerticalAlignment)class185.forOrdinal(var6, var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "85"
   )
   void method4857() {
      if(this.field3461 != null) {
         for(int var1 = 0; var1 < this.field3461.length; var1 += 2) {
            if(this.field3461[var1] < this.field3468) {
               this.field3468 = this.field3461[var1];
            } else if(this.field3461[var1] > this.field3464) {
               this.field3464 = this.field3461[var1];
            }

            if(this.field3461[var1 + 1] < this.field3466) {
               this.field3466 = this.field3461[var1 + 1];
            } else if(this.field3461[var1 + 1] > this.field3465) {
               this.field3465 = this.field3461[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ZI)Llv;",
      garbageValue = "-767149650"
   )
   @Export("getMapIcon")
   public SpritePixels getMapIcon(boolean var1) {
      int var2 = this.spriteId;
      return this.method4874(var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Llv;",
      garbageValue = "1795283266"
   )
   SpritePixels method4874(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)areaSpriteCache.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = AbstractByteBuffer.getSpriteAsSpritePixels(field3462, var1, 0);
            if(var2 != null) {
               areaSpriteCache.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "48896939"
   )
   public int method4865() {
      return this.id;
   }
}
