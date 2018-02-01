import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
public class class265 extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   static IndexDataBase field3492;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   static IndexDataBase field3469;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   static IndexDataBase field3476;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   static NodeCache field3471;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   static NodeCache field3480;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   static NodeCache field3473;
   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   @Export("indexCache15")
   static IndexData indexCache15;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -18442759
   )
   int field3478;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1567370725
   )
   public int field3483;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1010537151
   )
   public int field3487;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 771438991
   )
   int field3490;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1995772659
   )
   int field3482;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1851564415
   )
   int field3468;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 639932859
   )
   int field3484;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -784656431
   )
   public int field3485;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1698098365
   )
   public int field3470;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1703371103
   )
   public int field3481;
   @ObfuscatedName("u")
   String field3488;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 260017899
   )
   public int field3489;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -413265271
   )
   public int field3472;
   @ObfuscatedName("b")
   public int[] field3491;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1144896225
   )
   int field3479;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1867592821
   )
   int field3493;

   static {
      field3471 = new NodeCache(64);
      field3480 = new NodeCache(64);
      field3473 = new NodeCache(20);
   }

   class265() {
      this.field3478 = -1;
      this.field3483 = 16777215;
      this.field3487 = 70;
      this.field3490 = -1;
      this.field3482 = -1;
      this.field3468 = -1;
      this.field3484 = -1;
      this.field3485 = 0;
      this.field3470 = 0;
      this.field3481 = -1;
      this.field3488 = "";
      this.field3489 = -1;
      this.field3472 = 0;
      this.field3479 = -1;
      this.field3493 = -1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "-395794781"
   )
   void method4740(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4739(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgj;IB)V",
      garbageValue = "-44"
   )
   void method4739(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3478 = var1.method3414();
      } else if(var2 == 2) {
         this.field3483 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3490 = var1.method3414();
      } else if(var2 == 4) {
         this.field3468 = var1.method3414();
      } else if(var2 == 5) {
         this.field3482 = var1.method3414();
      } else if(var2 == 6) {
         this.field3484 = var1.method3414();
      } else if(var2 == 7) {
         this.field3485 = var1.readShort();
      } else if(var2 == 8) {
         this.field3488 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3487 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3470 = var1.readShort();
      } else if(var2 == 11) {
         this.field3481 = 0;
      } else if(var2 == 12) {
         this.field3489 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3472 = var1.readShort();
      } else if(var2 == 14) {
         this.field3481 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3479 = var1.readUnsignedShort();
         if(this.field3479 == 65535) {
            this.field3479 = -1;
         }

         this.field3493 = var1.readUnsignedShort();
         if(this.field3493 == 65535) {
            this.field3493 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3491 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3491[var5] = var1.readUnsignedShort();
            if(this.field3491[var5] == 65535) {
               this.field3491[var5] = -1;
            }
         }

         this.field3491[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Ljg;",
      garbageValue = "-957237581"
   )
   public final class265 method4773() {
      int var1 = -1;
      if(this.field3479 != -1) {
         var1 = LoginPacket.getVarbit(this.field3479);
      } else if(this.field3493 != -1) {
         var1 = class222.widgetSettings[this.field3493];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3491.length - 1) {
         var2 = this.field3491[var1];
      } else {
         var2 = this.field3491[this.field3491.length - 1];
      }

      return var2 != -1?class163.method3219(var2):null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "2000"
   )
   public String method4759(int var1) {
      String var2 = this.field3488;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         String var4 = var2.substring(0, var3);
         String var5 = Integer.toString(var1);
         var2 = var4 + var5 + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lko;",
      garbageValue = "1322629259"
   )
   public SpritePixels method4764() {
      if(this.field3490 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3480.get((long)this.field3490);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BaseVarType.method17(field3469, this.field3490, 0);
            if(var1 != null) {
               field3480.put(var1, (long)this.field3490);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Lko;",
      garbageValue = "73"
   )
   public SpritePixels method4743() {
      if(this.field3482 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3480.get((long)this.field3482);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BaseVarType.method17(field3469, this.field3482, 0);
            if(var1 != null) {
               field3480.put(var1, (long)this.field3482);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lko;",
      garbageValue = "1217238990"
   )
   public SpritePixels method4738() {
      if(this.field3468 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3480.get((long)this.field3468);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BaseVarType.method17(field3469, this.field3468, 0);
            if(var1 != null) {
               field3480.put(var1, (long)this.field3468);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Lko;",
      garbageValue = "1508243434"
   )
   public SpritePixels method4745() {
      if(this.field3484 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3480.get((long)this.field3484);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BaseVarType.method17(field3469, this.field3484, 0);
            if(var1 != null) {
               field3480.put(var1, (long)this.field3484);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Lkz;",
      garbageValue = "2002291493"
   )
   public Font method4746() {
      if(this.field3478 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3473.get((long)this.field3478);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ScriptVarType.method35(field3469, field3476, this.field3478, 0);
            if(var1 != null) {
               field3473.put(var1, (long)this.field3478);
            }

            return var1;
         }
      }
   }
}
