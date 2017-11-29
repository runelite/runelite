import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
public class class261 extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   static IndexDataBase field3498;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   static IndexDataBase field3477;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   static NodeCache field3476;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   static NodeCache field3479;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   static NodeCache field3480;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1286809105
   )
   int field3484;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1599773915
   )
   public int field3485;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1187516727
   )
   public int field3491;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -331615197
   )
   int field3487;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -453436153
   )
   int field3495;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1930434053
   )
   int field3489;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1685296785
   )
   int field3490;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1438836139
   )
   public int field3478;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -904931291
   )
   public int field3493;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2053648085
   )
   public int field3497;
   @ObfuscatedName("i")
   String field3494;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1132336991
   )
   public int field3492;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 349221473
   )
   public int field3486;
   @ObfuscatedName("g")
   public int[] field3496;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -508612915
   )
   int field3488;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 184541919
   )
   int field3499;

   static {
      field3476 = new NodeCache(64);
      field3479 = new NodeCache(64);
      field3480 = new NodeCache(20);
   }

   class261() {
      this.field3484 = -1;
      this.field3485 = 16777215;
      this.field3491 = 70;
      this.field3487 = -1;
      this.field3495 = -1;
      this.field3489 = -1;
      this.field3490 = -1;
      this.field3478 = 0;
      this.field3493 = 0;
      this.field3497 = -1;
      this.field3494 = "";
      this.field3492 = -1;
      this.field3486 = 0;
      this.field3488 = -1;
      this.field3499 = -1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "524020695"
   )
   void method4686(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4674(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lfr;IB)V",
      garbageValue = "11"
   )
   void method4674(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3484 = var1.method3444();
      } else if(var2 == 2) {
         this.field3485 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3487 = var1.method3444();
      } else if(var2 == 4) {
         this.field3489 = var1.method3444();
      } else if(var2 == 5) {
         this.field3495 = var1.method3444();
      } else if(var2 == 6) {
         this.field3490 = var1.method3444();
      } else if(var2 == 7) {
         this.field3478 = var1.readShort();
      } else if(var2 == 8) {
         this.field3494 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3491 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3493 = var1.readShort();
      } else if(var2 == 11) {
         this.field3497 = 0;
      } else if(var2 == 12) {
         this.field3492 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3486 = var1.readShort();
      } else if(var2 == 14) {
         this.field3497 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3488 = var1.readUnsignedShort();
         if(this.field3488 == 65535) {
            this.field3488 = -1;
         }

         this.field3499 = var1.readUnsignedShort();
         if(this.field3499 == 65535) {
            this.field3499 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3496 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3496[var5] = var1.readUnsignedShort();
            if(this.field3496[var5] == 65535) {
               this.field3496[var5] = -1;
            }
         }

         this.field3496[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Ljh;",
      garbageValue = "-179529830"
   )
   public final class261 method4661() {
      int var1 = -1;
      if(this.field3488 != -1) {
         var1 = Friend.getVarbit(this.field3488);
      } else if(this.field3499 != -1) {
         var1 = class218.widgetSettings[this.field3499];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3496.length - 1) {
         var2 = this.field3496[var1];
      } else {
         var2 = this.field3496[this.field3496.length - 1];
      }

      return var2 != -1?class64.method1105(var2):null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "524746400"
   )
   public String method4651(int var1) {
      String var2 = this.field3494;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + Signlink.method3068(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Lky;",
      garbageValue = "-121"
   )
   public SpritePixels method4652() {
      if(this.field3487 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3479.get((long)this.field3487);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ClassInfo.method5123(IntegerToken.field15, this.field3487, 0);
            if(var1 != null) {
               field3479.put(var1, (long)this.field3487);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lky;",
      garbageValue = "188392128"
   )
   public SpritePixels method4653() {
      if(this.field3495 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3479.get((long)this.field3495);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ClassInfo.method5123(IntegerToken.field15, this.field3495, 0);
            if(var1 != null) {
               field3479.put(var1, (long)this.field3495);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Lky;",
      garbageValue = "1166262388"
   )
   public SpritePixels method4654() {
      if(this.field3489 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3479.get((long)this.field3489);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ClassInfo.method5123(IntegerToken.field15, this.field3489, 0);
            if(var1 != null) {
               field3479.put(var1, (long)this.field3489);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lky;",
      garbageValue = "-1563512287"
   )
   public SpritePixels method4655() {
      if(this.field3490 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3479.get((long)this.field3490);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ClassInfo.method5123(IntegerToken.field15, this.field3490, 0);
            if(var1 != null) {
               field3479.put(var1, (long)this.field3490);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Ljp;",
      garbageValue = "339904222"
   )
   public Font method4656() {
      if(this.field3484 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3480.get((long)this.field3484);
         if(var1 != null) {
            return var1;
         } else {
            IndexDataBase var3 = IntegerToken.field15;
            IndexDataBase var4 = field3477;
            int var5 = this.field3484;
            Font var2;
            if(!GroundObject.method2603(var3, var5, 0)) {
               var2 = null;
            } else {
               byte[] var7 = var4.getConfigData(var5, 0);
               Font var6;
               if(var7 == null) {
                  var6 = null;
               } else {
                  Font var8 = new Font(var7, class295.field3848, class295.offsetsY, class295.field3845, class285.field3788, class115.field1599, TotalQuantityComparator.spritePixels);
                  class295.field3848 = null;
                  class295.offsetsY = null;
                  class295.field3845 = null;
                  class285.field3788 = null;
                  class115.field1599 = null;
                  TotalQuantityComparator.spritePixels = null;
                  var6 = var8;
               }

               var2 = var6;
            }

            if(var2 != null) {
               field3480.put(var2, (long)this.field3484);
            }

            return var2;
         }
      }
   }
}
