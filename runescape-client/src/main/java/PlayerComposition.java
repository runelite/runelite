import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("h")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("u")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1869061289
   )
   public int field2608;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -6572925093266166259L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 203471965754920499L
   )
   long field2610;
   @ObfuscatedName("p")
   public static short[][] field2611;
   @ObfuscatedName("k")
   static final int[] field2612;
   @ObfuscatedName("r")
   static NodeCache field2613;
   @ObfuscatedName("t")
   public static short[] field2615;
   @ObfuscatedName("i")
   @Export("equipmentIds")
   int[] equipmentIds;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1942817722"
   )
   public void method4008(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = field2611[var1].length - 1;
            }
         } while(!class14.method82(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= field2611[var1].length) {
               var3 = 0;
            }
         } while(!class14.method82(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.method4033();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1305274282"
   )
   public void method4009(boolean var1) {
      if(var1 != this.isFemale) {
         this.method4020((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "56"
   )
   public Model method4012(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field2608 != -1) {
         return class220.getNpcDefinition(this.field2608).method4703(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.equipmentIds;
         if(var1 != null && (var1.leftHandItem >= 0 || var1.rightHandItem >= 0)) {
            var7 = new int[12];

            for(int var15 = 0; var15 < 12; ++var15) {
               var7[var15] = this.equipmentIds[var15];
            }

            if(var1.leftHandItem >= 0) {
               var5 += (long)(var1.leftHandItem - this.equipmentIds[5] << 40);
               var7[5] = var1.leftHandItem;
            }

            if(var1.rightHandItem >= 0) {
               var5 += (long)(var1.rightHandItem - this.equipmentIds[3] << 48);
               var7[3] = var1.rightHandItem;
            }
         }

         Model var8 = (Model)field2613.get(var5);
         if(var8 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class116.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class51.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2610 != -1L) {
                  var8 = (Model)field2613.get(this.field2610);
               }

               if(var8 == null) {
                  return null;
               }
            }

            if(var8 == null) {
               ModelData[] var17 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class116.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class51.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < field2611[var13].length) {
                     var18.method2505(field2615[var13], field2611[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class98.field1521[var13].length) {
                     var18.method2505(class87.field1363[var13], class98.field1521[var13][this.bodyPartColours[var13]]);
                  }
               }

               var8 = var18.method2487(64, 850, -30, -50, -30);
               field2613.put(var8, var5);
               this.field2610 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var8;
         } else {
            Model var16;
            if(var1 != null && var3 != null) {
               var16 = var1.method4758(var8, var2, var3, var4);
            } else if(var1 != null) {
               var16 = var1.method4755(var8, var2);
            } else {
               var16 = var3.method4755(var8, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "1062019860"
   )
   ModelData method4013() {
      if(this.field2608 != -1) {
         return class220.getNpcDefinition(this.field2608).method4704();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !class116.getKitDefinition(var3 - 256).method4447()) {
               var1 = true;
            }

            if(var3 >= 512 && !class51.getItemDefinition(var3 - 512).method4640(this.isFemale)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var7 = new ModelData[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.equipmentIds[var4];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class116.getKitDefinition(var5 - 256).method4452();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class51.getItemDefinition(var5 - 512).method4643(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < field2611[var5].length) {
                  var8.method2505(field2615[var5], field2611[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class98.field1521[var5].length) {
                  var8.method2505(class87.field1363[var5], class98.field1521[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   static {
      field2612 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2613 = new NodeCache(260);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1517670189"
   )
   public void method4018(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2612[var2]];
         if(var3 == 0) {
            var1.putByte(-1);
         } else {
            var1.putByte(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.putByte(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([I[IZIB)V",
      garbageValue = "-106"
   )
   public void method4020(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3338; ++var6) {
               KitDefinition var7 = class116.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var7.bodyPartId == (var3?7:0) + var5) {
                  var1[field2612[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.field2608 = var4;
      this.method4033();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "142733967"
   )
   public int method4032() {
      return this.field2608 == -1?(this.equipmentIds[11] << 5) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20) + (this.equipmentIds[0] << 15) + (this.equipmentIds[8] << 10) + this.equipmentIds[1]:class220.getNpcDefinition(this.field2608).id + 305419896;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "52"
   )
   void method4033() {
      long var1 = this.hash;
      int var3 = this.equipmentIds[5];
      int var4 = this.equipmentIds[9];
      this.equipmentIds[5] = var4;
      this.equipmentIds[9] = var3;
      this.hash = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.hash <<= 4;
         if(this.equipmentIds[var5] >= 256) {
            this.hash += (long)(this.equipmentIds[var5] - 256);
         }
      }

      if(this.equipmentIds[0] >= 256) {
         this.hash += (long)(this.equipmentIds[0] - 256 >> 4);
      }

      if(this.equipmentIds[1] >= 256) {
         this.hash += (long)(this.equipmentIds[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.hash <<= 3;
         this.hash += (long)this.bodyPartColours[var5];
      }

      this.hash <<= 1;
      this.hash += (long)(this.isFemale?1:0);
      this.equipmentIds[5] = var3;
      this.equipmentIds[9] = var4;
      if(var1 != 0L && var1 != this.hash) {
         field2613.remove(var1);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "2095439512"
   )
   public void method4034(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2612[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field3338 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field3338) {
                     var3 = 0;
                  }
               }

               var4 = class116.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || var4.bodyPartId != var1 + (this.isFemale?7:0));

            this.equipmentIds[field2612[var1]] = var3 + 256;
            this.method4033();
         }
      }
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "325347457"
   )
   static void method4039(String var0) {
      class224.field2839 = var0;

      try {
         String var1 = class24.field356.getParameter(class274.field3717.field3711);
         String var2 = class24.field356.getParameter(class274.field3718.field3711);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + class111.method2116(class226.method4147() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         class52.method773(class24.field356, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var4) {
         ;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1715376646"
   )
   static void method4040(Component var0) {
      var0.addMouseListener(class59.mouse);
      var0.addMouseMotionListener(class59.mouse);
      var0.addFocusListener(class59.mouse);
   }
}
