import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class47 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("NetCache_responseArchiveBuffer")
   static Buffer NetCache_responseArchiveBuffer;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2027370325
   )
   int field588;
   @ObfuscatedName("k")
   byte[][][] field582;

   class47(int var1) {
      this.field588 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "14"
   )
   void method707(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field588 != 0 && this.field582 != null) {
         var8 = this.method746(var8, var7);
         var7 = this.method709(var7);
         Rasterizer2D.method5728(var1, var2, var5, var6, var3, var4, this.field582[var7 - 1][var8], this.field588);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2071926048"
   )
   int method746(int var1, int var2) {
      if(var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if(var2 == 10) {
         var1 = var1 + 3 & 3;
      }

      if(var2 == 11) {
         var1 = var1 + 3 & 3;
      }

      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "157940898"
   )
   int method709(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-921784955"
   )
   void method734() {
      if(this.field582 == null) {
         this.field582 = new byte[8][4][];
         this.method731();
         this.method712();
         this.method713();
         this.method723();
         this.method722();
         this.method716();
         this.method724();
         this.method718();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1781318735"
   )
   void method731() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[0][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[0][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[0][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[0][3] = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-565470863"
   )
   void method712() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[1][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var2 >= 0 && var2 < var1.length) {
               if(var4 >= var3 << 1) {
                  var1[var2] = -1;
               }

               ++var2;
            } else {
               ++var2;
            }
         }
      }

      this.field582[1][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[1][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[1][3] = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   void method713() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[2][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[2][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[2][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[2][3] = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1537613471"
   )
   void method723() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[3][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[3][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[3][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[3][3] = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "231500092"
   )
   void method722() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[4][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[4][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[4][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[4][3] = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1591164379"
   )
   void method716() {
      byte[] var1 = new byte[this.field588 * this.field588];
      boolean var2 = false;
      var1 = new byte[this.field588 * this.field588];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[5][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var3 <= this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[5][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[5][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var3 >= this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[5][3] = var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1658845473"
   )
   void method724() {
      byte[] var1 = new byte[this.field588 * this.field588];
      boolean var2 = false;
      var1 = new byte[this.field588 * this.field588];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[6][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[6][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[6][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[6][3] = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-107"
   )
   void method718() {
      byte[] var1 = new byte[this.field588 * this.field588];
      boolean var2 = false;
      var1 = new byte[this.field588 * this.field588];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[7][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[7][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[7][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[7][3] = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Ljo;",
      garbageValue = "1198164512"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.items.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.item_ref.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.post();
         if(var1.notedTemplate != -1) {
            var1.updateNote(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method5059(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.placeholderTemplateId != -1) {
            var1.method5076(getItemDefinition(var1.placeholderTemplateId), getItemDefinition(var1.placeholderId));
         }

         if(!class158.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.isTradable = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.shiftClickIndex = -1;
            var1.team = 0;
            if(var1.params != null) {
               boolean var3 = false;

               for(Node var4 = var1.params.getHead(); var4 != null; var4 = var1.params.getTail()) {
                  class278 var5 = CombatInfo2.method4877((int)var4.hash);
                  if(var5.field3550) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.params = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "240168383"
   )
   static int method747(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if(var0 == 4100) {
         var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
         var4 = class81.intStack[--WorldComparator.intStackSize];
         class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var37;
         if(var0 == 4101) {
            KeyFocusListener.scriptStringStackSize -= 2;
            var3 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize];
            var37 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3 + var37;
            return 1;
         } else if(var0 == 4102) {
            var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
            var4 = class81.intStack[--WorldComparator.intStackSize];
            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3 + ScriptVarType.method19(var4, true);
            return 1;
         } else if(var0 == 4103) {
            var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var8;
            int var21;
            int var28;
            if(var0 == 4104) {
               var21 = class81.intStack[--WorldComparator.intStackSize];
               long var22 = 86400000L * ((long)var21 + 11745L);
               class81.field1284.setTime(new Date(var22));
               var28 = class81.field1284.get(5);
               int var29 = class81.field1284.get(2);
               var8 = class81.field1284.get(1);
               class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var28 + "-" + class81.field1291[var29] + "-" + var8;
               return 1;
            } else if(var0 == 4105) {
               KeyFocusListener.scriptStringStackSize -= 2;
               var3 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize];
               var37 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
               if(SoundTaskDataProvider.localPlayer.composition != null && SoundTaskDataProvider.localPlayer.composition.isFemale) {
                  class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var37;
               } else {
                  class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4106) {
               var21 = class81.intStack[--WorldComparator.intStackSize];
               class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = Integer.toString(var21);
               return 1;
            } else {
               int var5;
               if(var0 == 4107) {
                  KeyFocusListener.scriptStringStackSize -= 2;
                  int[] var27 = class81.intStack;
                  var4 = ++WorldComparator.intStackSize - 1;
                  String var39 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                  String var40 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                  var8 = Client.languageId;
                  int var9 = var39.length();
                  int var10 = var40.length();
                  int var11 = 0;
                  int var12 = 0;
                  byte var13 = 0;
                  byte var14 = 0;

                  label318:
                  while(true) {
                     if(var11 - var13 >= var9 && var12 - var14 >= var10) {
                        int var32 = Math.min(var9, var10);

                        int var33;
                        char var36;
                        for(var33 = 0; var33 < var32; ++var33) {
                           char var34 = var39.charAt(var33);
                           var36 = var40.charAt(var33);
                           if(var34 != var36 && Character.toUpperCase(var34) != Character.toUpperCase(var36)) {
                              var34 = Character.toLowerCase(var34);
                              var36 = Character.toLowerCase(var36);
                              if(var36 != var34) {
                                 var5 = GrandExchangeEvent.method83(var34, var8) - GrandExchangeEvent.method83(var36, var8);
                                 break label318;
                              }
                           }
                        }

                        var33 = var9 - var10;
                        if(var33 != 0) {
                           var5 = var33;
                        } else {
                           for(int var35 = 0; var35 < var32; ++var35) {
                              var36 = var39.charAt(var35);
                              char var19 = var40.charAt(var35);
                              if(var19 != var36) {
                                 var5 = GrandExchangeEvent.method83(var36, var8) - GrandExchangeEvent.method83(var19, var8);
                                 break label318;
                              }
                           }

                           var5 = 0;
                        }
                        break;
                     }

                     if(var11 - var13 >= var9) {
                        var5 = -1;
                        break;
                     }

                     if(var12 - var14 >= var10) {
                        var5 = 1;
                        break;
                     }

                     char var15;
                     if(var13 != 0) {
                        var15 = (char)var13;
                        boolean var30 = false;
                     } else {
                        var15 = var39.charAt(var11++);
                     }

                     char var16;
                     if(var14 != 0) {
                        var16 = (char)var14;
                        boolean var31 = false;
                     } else {
                        var16 = var40.charAt(var12++);
                     }

                     byte var17;
                     if(var15 == 198) {
                        var17 = 69;
                     } else if(var15 == 230) {
                        var17 = 101;
                     } else if(var15 == 223) {
                        var17 = 115;
                     } else if(var15 == 338) {
                        var17 = 69;
                     } else if(var15 == 339) {
                        var17 = 101;
                     } else {
                        var17 = 0;
                     }

                     var13 = var17;
                     byte var18;
                     if(var16 == 198) {
                        var18 = 69;
                     } else if(var16 == 230) {
                        var18 = 101;
                     } else if(var16 == 223) {
                        var18 = 115;
                     } else if(var16 == 338) {
                        var18 = 69;
                     } else if(var16 == 339) {
                        var18 = 101;
                     } else {
                        var18 = 0;
                     }

                     var14 = var18;
                     var15 = class185.method3443(var15, var8);
                     var16 = class185.method3443(var16, var8);
                     if(var15 != var16 && Character.toUpperCase(var15) != Character.toUpperCase(var16)) {
                        var15 = Character.toLowerCase(var15);
                        var16 = Character.toLowerCase(var16);
                        if(var15 != var16) {
                           var5 = GrandExchangeEvent.method83(var15, var8) - GrandExchangeEvent.method83(var16, var8);
                           break;
                        }
                     }
                  }

                  var27[var4] = class248.method4500(var5);
                  return 1;
               } else {
                  byte[] var24;
                  Font var25;
                  if(var0 == 4108) {
                     var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                     WorldComparator.intStackSize -= 2;
                     var4 = class81.intStack[WorldComparator.intStackSize];
                     var5 = class81.intStack[WorldComparator.intStackSize + 1];
                     var24 = KeyFocusListener.indexCache13.getConfigData(var5, 0);
                     var25 = new Font(var24);
                     class81.intStack[++WorldComparator.intStackSize - 1] = var25.method5508(var3, var4);
                     return 1;
                  } else if(var0 == 4109) {
                     var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                     WorldComparator.intStackSize -= 2;
                     var4 = class81.intStack[WorldComparator.intStackSize];
                     var5 = class81.intStack[WorldComparator.intStackSize + 1];
                     var24 = KeyFocusListener.indexCache13.getConfigData(var5, 0);
                     var25 = new Font(var24);
                     class81.intStack[++WorldComparator.intStackSize - 1] = var25.method5507(var3, var4);
                     return 1;
                  } else if(var0 == 4110) {
                     KeyFocusListener.scriptStringStackSize -= 2;
                     var3 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                     var37 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                     if(class81.intStack[--WorldComparator.intStackSize] == 1) {
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3;
                     } else {
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var37;
                     }

                     return 1;
                  } else if(var0 == 4111) {
                     var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = FontTypeFace.appendTags(var3);
                     return 1;
                  } else if(var0 == 4112) {
                     var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                     var4 = class81.intStack[--WorldComparator.intStackSize];
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else {
                     boolean var6;
                     char var7;
                     int[] var20;
                     if(var0 == 4113) {
                        var21 = class81.intStack[--WorldComparator.intStackSize];
                        var20 = class81.intStack;
                        var5 = ++WorldComparator.intStackSize - 1;
                        var7 = (char)var21;
                        if(var7 >= ' ' && var7 <= '~') {
                           var6 = true;
                        } else if(var7 >= 160 && var7 <= 255) {
                           var6 = true;
                        } else if(var7 != 8364 && var7 != 338 && var7 != 8212 && var7 != 339 && var7 != 376) {
                           var6 = false;
                        } else {
                           var6 = true;
                        }

                        var20[var5] = var6?1:0;
                        return 1;
                     } else if(var0 == 4114) {
                        var21 = class81.intStack[--WorldComparator.intStackSize];
                        var20 = class81.intStack;
                        var5 = ++WorldComparator.intStackSize - 1;
                        var7 = (char)var21;
                        var6 = var7 >= '0' && var7 <= '9' || var7 >= 'A' && var7 <= 'Z' || var7 >= 'a' && var7 <= 'z';
                        var20[var5] = var6?1:0;
                        return 1;
                     } else if(var0 != 4115) {
                        if(var0 == 4116) {
                           var21 = class81.intStack[--WorldComparator.intStackSize];
                           class81.intStack[++WorldComparator.intStackSize - 1] = class64.method1111((char)var21)?1:0;
                           return 1;
                        } else if(var0 == 4117) {
                           var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                           if(var3 != null) {
                              class81.intStack[++WorldComparator.intStackSize - 1] = var3.length();
                           } else {
                              class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                           }

                           return 1;
                        } else if(var0 == 4118) {
                           var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                           WorldComparator.intStackSize -= 2;
                           var4 = class81.intStack[WorldComparator.intStackSize];
                           var5 = class81.intStack[WorldComparator.intStackSize + 1];
                           class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.substring(var4, var5);
                           return 1;
                        } else if(var0 == 4119) {
                           var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                           StringBuilder var38 = new StringBuilder(var3.length());
                           boolean var26 = false;

                           for(var28 = 0; var28 < var3.length(); ++var28) {
                              var7 = var3.charAt(var28);
                              if(var7 == '<') {
                                 var26 = true;
                              } else if(var7 == '>') {
                                 var26 = false;
                              } else if(!var26) {
                                 var38.append(var7);
                              }
                           }

                           class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var38.toString();
                           return 1;
                        } else if(var0 == 4120) {
                           var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                           var4 = class81.intStack[--WorldComparator.intStackSize];
                           class81.intStack[++WorldComparator.intStackSize - 1] = var3.indexOf(var4);
                           return 1;
                        } else if(var0 == 4121) {
                           KeyFocusListener.scriptStringStackSize -= 2;
                           var3 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                           var37 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                           var5 = class81.intStack[--WorldComparator.intStackSize];
                           class81.intStack[++WorldComparator.intStackSize - 1] = var3.indexOf(var37, var5);
                           return 1;
                        } else {
                           return 2;
                        }
                     } else {
                        var21 = class81.intStack[--WorldComparator.intStackSize];
                        var20 = class81.intStack;
                        var5 = ++WorldComparator.intStackSize - 1;
                        var7 = (char)var21;
                        var6 = var7 >= 'A' && var7 <= 'Z' || var7 >= 'a' && var7 <= 'z';
                        var20[var5] = var6?1:0;
                        return 1;
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "([Lin;IB)V",
      garbageValue = "17"
   )
   static final void method739(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1) {
            boolean var4;
            if(var3.hasScript) {
               var4 = var3.isHidden;
               if(var4) {
                  continue;
               }
            }

            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript) {
                  var4 = var3.isHidden;
                  if(var4 && var3 != BoundingBox3D.field259) {
                     continue;
                  }
               }

               method739(var0, var3.id);
               if(var3.children != null) {
                  method739(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var7 != null) {
                  var5 = var7.id;
                  if(class189.loadWidget(var5)) {
                     method739(MouseRecorder.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2869 != -1 || var3.field2855 != -1) {
                  var4 = class27.method246(var3);
                  if(var4) {
                     var5 = var3.field2855;
                  } else {
                     var5 = var3.field2869;
                  }

                  if(var5 != -1) {
                     Sequence var6 = CombatInfo1.getAnimation(var5);

                     for(var3.field2945 += Client.field930; var3.field2945 > var6.frameLengths[var3.field2935]; FontName.method5490(var3)) {
                        var3.field2945 -= var6.frameLengths[var3.field2935];
                        ++var3.field2935;
                        if(var3.field2935 >= var6.frameIDs.length) {
                           var3.field2935 -= var6.frameStep;
                           if(var3.field2935 < 0 || var3.field2935 >= var6.frameIDs.length) {
                              var3.field2935 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2904 != 0 && !var3.hasScript) {
                  int var8 = var3.field2904 >> 16;
                  var5 = var3.field2904 << 16 >> 16;
                  var8 *= Client.field930;
                  var5 *= Client.field930;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  FontName.method5490(var3);
               }
            }
         }
      }

   }
}
