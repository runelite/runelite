import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class1 {
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      longValue = -1505547449554748095L
   )
   static long field5;
   @ObfuscatedName("l")
   public static Comparator field6 = new class7();
   @ObfuscatedName("i")
   public static Comparator field7;
   @ObfuscatedName("t")
   public static Comparator field8;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = 1262684339
   )
   static int field10;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = 1558056607
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("b")
   public final List field12;
   @ObfuscatedName("bj")
   static class184 field13;
   @ObfuscatedName("k")
   public static Comparator field14;

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1719335023"
   )
   static final void method14() {
      XGrandExchangeOffer.method71();
      if(null == class5.field50) {
         if(null == Client.field458) {
            int var1;
            int var3;
            int var4;
            int var11;
            label294: {
               int var0 = class115.field1796;
               int var2;
               int var7;
               if(Client.isMenuOpen) {
                  if(var0 != 1 && (class36.field769 || var0 != 4)) {
                     var1 = class115.field1802;
                     var2 = class115.field1801;
                     if(var1 < MessageNode.menuX - 10 || var1 > class36.menuWidth + MessageNode.menuX + 10 || var2 < class137.menuY - 10 || var2 > 10 + class212.menuHeight + class137.menuY) {
                        Client.isMenuOpen = false;
                        class105.method2076(MessageNode.menuX, class137.menuY, class36.menuWidth, class212.menuHeight);
                     }
                  }

                  if(var0 == 1 || !class36.field769 && var0 == 4) {
                     var1 = MessageNode.menuX;
                     var2 = class137.menuY;
                     var3 = class36.menuWidth;
                     var4 = class115.field1808;
                     int var5 = class115.field1798;
                     var11 = -1;

                     for(var7 = 0; var7 < Client.menuOptionCount; ++var7) {
                        int var8 = var2 + 31 + 15 * (Client.menuOptionCount - 1 - var7);
                        if(var4 > var1 && var4 < var1 + var3 && var5 > var8 - 13 && var5 < 3 + var8) {
                           var11 = var7;
                        }
                     }

                     if(var11 != -1) {
                        class196.method3641(var11);
                     }

                     Client.isMenuOpen = false;
                     class105.method2076(MessageNode.menuX, class137.menuY, class36.menuWidth, class212.menuHeight);
                  }
               } else {
                  var1 = class7.method110();
                  if((var0 == 1 || !class36.field769 && var0 == 4) && var1 >= 0) {
                     var2 = Client.menuTypes[var1];
                     if(var2 == 39 || var2 == 40 || var2 == 41 || var2 == 42 || var2 == 43 || var2 == 33 || var2 == 34 || var2 == 35 || var2 == 36 || var2 == 37 || var2 == 38 || var2 == 1005) {
                        var3 = Client.menuActionParams0[var1];
                        var4 = Client.menuActionParams1[var1];
                        Widget var9 = class140.method2681(var4);
                        if(Player.method256(class8.method112(var9))) {
                           break label294;
                        }

                        var7 = class8.method112(var9);
                        boolean var6 = (var7 >> 29 & 1) != 0;
                        if(var6) {
                           break label294;
                        }
                     }
                  }

                  if(var0 == 1 || !class36.field769 && var0 == 4) {
                     label300: {
                        label214: {
                           if(Client.field422 == 1 && Client.menuOptionCount > 2) {
                              boolean var10;
                              if(Client.menuOptionCount <= 0) {
                                 var10 = false;
                              } else if(Client.field433 && class105.field1700[81] && Client.field432 != -1) {
                                 var10 = true;
                              } else {
                                 var10 = false;
                              }

                              if(!var10) {
                                 break label214;
                              }
                           }

                           if(!class72.method1464(var1)) {
                              break label300;
                           }
                        }

                        var0 = 2;
                     }
                  }

                  if((var0 == 1 || !class36.field769 && var0 == 4) && Client.menuOptionCount > 0) {
                     class196.method3641(var1);
                  }

                  if(var0 == 2 && Client.menuOptionCount > 0) {
                     class168.method3260(class115.field1808, class115.field1798);
                  }
               }

               return;
            }

            if(null != class5.field50 && !Client.field402) {
               var11 = class7.method110();
               if(Client.field422 != 1 && !class72.method1464(var11) && Client.menuOptionCount > 0) {
                  class60.method1205(Client.field399, Client.field491);
               }
            }

            Client.field402 = false;
            Client.field403 = 0;
            if(null != class5.field50) {
               Frames.method1960(class5.field50);
            }

            class5.field50 = class140.method2681(var4);
            Client.field398 = var3;
            Client.field399 = class115.field1808;
            Client.field491 = class115.field1798;
            if(var1 >= 0) {
               class180.field2698 = new class38();
               class180.field2698.field797 = Client.menuActionParams0[var1];
               class180.field2698.field790 = Client.menuActionParams1[var1];
               class180.field2698.field791 = Client.menuTypes[var1];
               class180.field2698.field792 = Client.menuIdentifiers[var1];
               class180.field2698.field793 = Client.menuOptions[var1];
            }

            Frames.method1960(class5.field50);
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class1(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field12 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field12.add(new class2(var1, var5, var3));
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-685022002"
   )
   public void method18(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field12, var1);
      } else {
         Collections.sort(this.field12, Collections.reverseOrder(var1));
      }

   }

   static {
      new class0();
      field7 = new class5();
      field8 = new class6();
      field14 = new class3();
   }
}
