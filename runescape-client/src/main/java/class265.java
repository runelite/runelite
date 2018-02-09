import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
public class class265 extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   static IndexDataBase field3500;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   static NodeCache field3490;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   static NodeCache field3495;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   static NodeCache field3492;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -1409275449
   )
   static int field3502;
   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   static Widget field3515;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -111663013
   )
   int field3497;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -455883103
   )
   public int field3498;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1026814659
   )
   public int field3499;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -591442613
   )
   int field3489;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -84871783
   )
   int field3501;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -23275649
   )
   int field3512;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1350960029
   )
   int field3503;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -684022073
   )
   public int field3504;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 971917895
   )
   public int field3505;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1842894847
   )
   public int field3506;
   @ObfuscatedName("n")
   String field3507;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2108587953
   )
   public int field3508;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 226704103
   )
   public int field3496;
   @ObfuscatedName("v")
   public int[] field3514;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1894001111
   )
   int field3511;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1986543379
   )
   int field3491;

   static {
      field3490 = new NodeCache(64);
      field3495 = new NodeCache(64);
      field3492 = new NodeCache(20);
   }

   class265() {
      this.field3497 = -1;
      this.field3498 = 16777215;
      this.field3499 = 70;
      this.field3489 = -1;
      this.field3501 = -1;
      this.field3512 = -1;
      this.field3503 = -1;
      this.field3504 = 0;
      this.field3505 = 0;
      this.field3506 = -1;
      this.field3507 = "";
      this.field3508 = -1;
      this.field3496 = 0;
      this.field3511 = -1;
      this.field3491 = -1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;B)V",
      garbageValue = "60"
   )
   void method4884(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4885(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "1989071361"
   )
   void method4885(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3497 = var1.method3715();
      } else if(var2 == 2) {
         this.field3498 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3489 = var1.method3715();
      } else if(var2 == 4) {
         this.field3512 = var1.method3715();
      } else if(var2 == 5) {
         this.field3501 = var1.method3715();
      } else if(var2 == 6) {
         this.field3503 = var1.method3715();
      } else if(var2 == 7) {
         this.field3504 = var1.readShort();
      } else if(var2 == 8) {
         this.field3507 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3499 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3505 = var1.readShort();
      } else if(var2 == 11) {
         this.field3506 = 0;
      } else if(var2 == 12) {
         this.field3508 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3496 = var1.readShort();
      } else if(var2 == 14) {
         this.field3506 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3511 = var1.readUnsignedShort();
         if(this.field3511 == 65535) {
            this.field3511 = -1;
         }

         this.field3491 = var1.readUnsignedShort();
         if(this.field3491 == 65535) {
            this.field3491 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3514 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3514[var5] = var1.readUnsignedShort();
            if(this.field3514[var5] == 65535) {
               this.field3514[var5] = -1;
            }
         }

         this.field3514[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)Ljt;",
      garbageValue = "12436"
   )
   public final class265 method4886() {
      int var1 = -1;
      if(this.field3511 != -1) {
         var1 = BoundingBox3DDrawMode.getVarbit(this.field3511);
      } else if(this.field3491 != -1) {
         var1 = class222.widgetSettings[this.field3491];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3514.length - 1) {
         var2 = this.field3514[var1];
      } else {
         var2 = this.field3514[this.field3514.length - 1];
      }

      return var2 != -1?Size.method181(var2):null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1130050699"
   )
   public String method4887(int var1) {
      String var2 = this.field3507;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + VertexNormal.method2814(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lki;",
      garbageValue = "475578550"
   )
   public SpritePixels method4904() {
      if(this.field3489 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3495.get((long)this.field3489);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ScriptEvent.method1074(class294.field3803, this.field3489, 0);
            if(var1 != null) {
               field3495.put(var1, (long)this.field3489);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lki;",
      garbageValue = "85844767"
   )
   public SpritePixels method4889() {
      if(this.field3501 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3495.get((long)this.field3501);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ScriptEvent.method1074(class294.field3803, this.field3501, 0);
            if(var1 != null) {
               field3495.put(var1, (long)this.field3501);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Lki;",
      garbageValue = "-2043934513"
   )
   public SpritePixels method4900() {
      if(this.field3512 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3495.get((long)this.field3512);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ScriptEvent.method1074(class294.field3803, this.field3512, 0);
            if(var1 != null) {
               field3495.put(var1, (long)this.field3512);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Lki;",
      garbageValue = "-832568027"
   )
   public SpritePixels method4891() {
      if(this.field3503 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3495.get((long)this.field3503);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ScriptEvent.method1074(class294.field3803, this.field3503, 0);
            if(var1 != null) {
               field3495.put(var1, (long)this.field3503);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Lkp;",
      garbageValue = "-42"
   )
   public Font method4903() {
      if(this.field3497 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3492.get((long)this.field3497);
         if(var1 != null) {
            return var1;
         } else {
            IndexDataBase var3 = class294.field3803;
            IndexDataBase var4 = class2.field9;
            int var5 = this.field3497;
            Font var2;
            if(!class35.method484(var3, var5, 0)) {
               var2 = null;
            } else {
               byte[] var7 = var4.getConfigData(var5, 0);
               Font var6;
               if(var7 == null) {
                  var6 = null;
               } else {
                  Font var8 = new Font(var7, class219.field2698, class263.offsetsY, class60.field708, class310.field3911, class289.field3786, class310.spritePixels);
                  Name.method5282();
                  var6 = var8;
               }

               var2 = var6;
            }

            if(var2 != null) {
               field3492.put(var2, (long)this.field3497);
            }

            return var2;
         }
      }
   }
}
