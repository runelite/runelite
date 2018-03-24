import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   public static IndexDataBase field3466;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "[Ljj;"
   )
   @Export("mapAreaType")
   public static Area[] mapAreaType;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -946152793
   )
   public static int field3455;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("areaSpriteCache")
   static NodeCache areaSpriteCache;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -207486207
   )
   @Export("id")
   public final int id;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -783832613
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -932732095
   )
   int field3453;
   @ObfuscatedName("x")
   @Export("name")
   public String name;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 857868649
   )
   public int field3473;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2081354473
   )
   public int field3462;
   @ObfuscatedName("o")
   public String[] field3465;
   @ObfuscatedName("c")
   public String field3476;
   @ObfuscatedName("v")
   int[] field3459;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 504598791
   )
   int field3467;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1933128975
   )
   int field3461;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1465153773
   )
   int field3468;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 996992135
   )
   int field3469;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("horizontalAlignment")
   public HorizontalAlignment horizontalAlignment;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("verticalAlignment")
   public VerticalAlignment verticalAlignment;
   @ObfuscatedName("d")
   int[] field3472;
   @ObfuscatedName("f")
   byte[] field3471;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -490974915
   )
   public int field3474;

   static {
      areaSpriteCache = new NodeCache(256);
   }

   public Area(int var1) {
      this.spriteId = -1;
      this.field3453 = -1;
      this.field3462 = 0;
      this.field3465 = new String[5];
      this.field3467 = Integer.MAX_VALUE;
      this.field3461 = Integer.MAX_VALUE;
      this.field3468 = Integer.MIN_VALUE;
      this.field3469 = Integer.MIN_VALUE;
      this.horizontalAlignment = HorizontalAlignment.field3701;
      this.verticalAlignment = VerticalAlignment.field3439;
      this.field3474 = -1;
      this.id = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgb;B)V",
      garbageValue = "46"
   )
   public void method4768(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4777(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgb;IB)V",
      garbageValue = "116"
   )
   void method4777(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3553();
      } else if(var2 == 2) {
         this.field3453 = var1.method3553();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3473 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3462 = var1.readUnsignedByte();
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
            this.field3465[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3459 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3459[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3472 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3472.length; ++var5) {
               this.field3472[var5] = var1.readInt();
            }

            this.field3471 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3471[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3476 = var1.readString();
            } else if(var2 == 18) {
               var1.method3553();
            } else if(var2 == 19) {
               this.field3474 = var1.readUnsignedShort();
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
               var1.method3553();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               this.horizontalAlignment = (HorizontalAlignment)WorldMapRectangle.forOrdinal(class236.method4387(), var1.readUnsignedByte());
            } else if(var2 == 30) {
               this.verticalAlignment = (VerticalAlignment)WorldMapRectangle.forOrdinal(BaseVarType.method12(), var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "685445531"
   )
   public void method4782() {
      if(this.field3459 != null) {
         for(int var1 = 0; var1 < this.field3459.length; var1 += 2) {
            if(this.field3459[var1] < this.field3467) {
               this.field3467 = this.field3459[var1];
            } else if(this.field3459[var1] > this.field3468) {
               this.field3468 = this.field3459[var1];
            }

            if(this.field3459[var1 + 1] < this.field3461) {
               this.field3461 = this.field3459[var1 + 1];
            } else if(this.field3459[var1 + 1] > this.field3469) {
               this.field3469 = this.field3459[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZI)Lla;",
      garbageValue = "-1235363229"
   )
   @Export("getMapIcon")
   public SpritePixels getMapIcon(boolean var1) {
      int var2 = this.spriteId;
      return this.method4772(var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lla;",
      garbageValue = "-1818275198"
   )
   SpritePixels method4772(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)areaSpriteCache.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class1.method1(field3466, var1, 0);
            if(var2 != null) {
               areaSpriteCache.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1669479344"
   )
   public int method4773() {
      return this.id;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1075361700"
   )
   static final void method4767(String var0) {
      MapIconReference.method757(var0 + " is already on your ignore list");
   }
}
