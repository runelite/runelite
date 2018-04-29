import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
public class class281 extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static IndexDataBase field3576;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static IndexDataBase field3573;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static IndexDataBase field3567;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static NodeCache field3568;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static NodeCache field3584;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static NodeCache field3570;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 527847885
   )
   int field3574;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 587538359
   )
   public int field3575;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 682468389
   )
   public int field3580;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1906515727
   )
   int field3577;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1195833549
   )
   int field3578;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1355011043
   )
   int field3579;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1836499211
   )
   int field3565;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -460122143
   )
   public int field3581;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1863309679
   )
   public int field3582;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1803568633
   )
   public int field3566;
   @ObfuscatedName("w")
   String field3583;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 18388741
   )
   public int field3585;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 895774225
   )
   public int field3586;
   @ObfuscatedName("x")
   public int[] field3587;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2039311445
   )
   int field3569;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -914660273
   )
   int field3589;

   static {
      field3568 = new NodeCache(64);
      field3584 = new NodeCache(64);
      field3570 = new NodeCache(20);
   }

   class281() {
      this.field3574 = -1;
      this.field3575 = 16777215;
      this.field3580 = 70;
      this.field3577 = -1;
      this.field3578 = -1;
      this.field3579 = -1;
      this.field3565 = -1;
      this.field3581 = 0;
      this.field3582 = 0;
      this.field3566 = -1;
      this.field3583 = "";
      this.field3585 = -1;
      this.field3586 = 0;
      this.field3569 = -1;
      this.field3589 = -1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgg;I)V",
      garbageValue = "709387834"
   )
   void method5044(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method5045(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgg;II)V",
      garbageValue = "-1417911702"
   )
   void method5045(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3574 = var1.method3614();
      } else if(var2 == 2) {
         this.field3575 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3577 = var1.method3614();
      } else if(var2 == 4) {
         this.field3579 = var1.method3614();
      } else if(var2 == 5) {
         this.field3578 = var1.method3614();
      } else if(var2 == 6) {
         this.field3565 = var1.method3614();
      } else if(var2 == 7) {
         this.field3581 = var1.readShort();
      } else if(var2 == 8) {
         this.field3583 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3580 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3582 = var1.readShort();
      } else if(var2 == 11) {
         this.field3566 = 0;
      } else if(var2 == 12) {
         this.field3585 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3586 = var1.readShort();
      } else if(var2 == 14) {
         this.field3566 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3569 = var1.readUnsignedShort();
         if(this.field3569 == 65535) {
            this.field3569 = -1;
         }

         this.field3589 = var1.readUnsignedShort();
         if(this.field3589 == 65535) {
            this.field3589 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3587 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3587[var5] = var1.readUnsignedShort();
            if(this.field3587[var5] == 65535) {
               this.field3587[var5] = -1;
            }
         }

         this.field3587[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Ljl;",
      garbageValue = "-768979564"
   )
   public final class281 method5047() {
      int var1 = -1;
      if(this.field3569 != -1) {
         var1 = VarCString.getVarbit(this.field3569);
      } else if(this.field3589 != -1) {
         var1 = class237.clientVarps[this.field3589];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3587.length - 1) {
         var2 = this.field3587[var1];
      } else {
         var2 = this.field3587[this.field3587.length - 1];
      }

      return var2 != -1?FileRequest.method4638(var2):null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-337090113"
   )
   public String method5043(int var1) {
      String var2 = this.field3583;

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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Llv;",
      garbageValue = "287904679"
   )
   public SpritePixels method5048() {
      if(this.field3577 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3584.get((long)this.field3577);
         if(var1 != null) {
            return var1;
         } else {
            var1 = AbstractByteBuffer.method3836(field3573, this.field3577, 0);
            if(var1 != null) {
               field3584.put(var1, (long)this.field3577);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Llv;",
      garbageValue = "-814884531"
   )
   public SpritePixels method5074() {
      if(this.field3578 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3584.get((long)this.field3578);
         if(var1 != null) {
            return var1;
         } else {
            var1 = AbstractByteBuffer.method3836(field3573, this.field3578, 0);
            if(var1 != null) {
               field3584.put(var1, (long)this.field3578);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Llv;",
      garbageValue = "-1726534528"
   )
   public SpritePixels method5050() {
      if(this.field3579 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3584.get((long)this.field3579);
         if(var1 != null) {
            return var1;
         } else {
            var1 = AbstractByteBuffer.method3836(field3573, this.field3579, 0);
            if(var1 != null) {
               field3584.put(var1, (long)this.field3579);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Llv;",
      garbageValue = "-106"
   )
   public SpritePixels method5051() {
      if(this.field3565 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3584.get((long)this.field3565);
         if(var1 != null) {
            return var1;
         } else {
            var1 = AbstractByteBuffer.method3836(field3573, this.field3565, 0);
            if(var1 != null) {
               field3584.put(var1, (long)this.field3565);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lkh;",
      garbageValue = "-1540423765"
   )
   public Font method5052() {
      if(this.field3574 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3570.get((long)this.field3574);
         if(var1 != null) {
            return var1;
         } else {
            IndexDataBase var3 = field3573;
            IndexDataBase var4 = field3567;
            int var5 = this.field3574;
            Font var2;
            if(!class326.method5792(var3, var5, 0)) {
               var2 = null;
            } else {
               var2 = AbstractByteBuffer.method3837(var4.getConfigData(var5, 0));
            }

            if(var2 != null) {
               field3570.put(var2, (long)this.field3574);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Z",
      garbageValue = "-1252700971"
   )
   static boolean method5078(String var0, int var1) {
      return class7.method28(var0, var1, "openjs");
   }
}
