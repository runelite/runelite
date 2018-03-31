import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ko")
@Implements("Name")
public class Name implements Comparable {
   @ObfuscatedName("c")
   @Export("name")
   String name;
   @ObfuscatedName("i")
   @Export("cleanName")
   String cleanName;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Llo;)V"
   )
   public Name(String var1, JagexLoginType var2) {
      this.name = var1;
      String var4;
      if(var1 == null) {
         var4 = null;
      } else {
         int var5 = 0;

         int var6;
         boolean var7;
         char var8;
         for(var6 = var1.length(); var5 < var6; ++var5) {
            var8 = var1.charAt(var5);
            var7 = var8 == 160 || var8 == ' ' || var8 == '_' || var8 == '-';
            if(!var7) {
               break;
            }
         }

         while(var6 > var5) {
            var8 = var1.charAt(var6 - 1);
            var7 = var8 == 160 || var8 == ' ' || var8 == '_' || var8 == '-';
            if(!var7) {
               break;
            }

            --var6;
         }

         int var17 = var6 - var5;
         if(var17 >= 1 && var17 <= ClanMemberManager.method5491(var2)) {
            StringBuilder var16 = new StringBuilder(var17);

            for(int var9 = var5; var9 < var6; ++var9) {
               char var10 = var1.charAt(var9);
               boolean var11;
               if(Character.isISOControl(var10)) {
                  var11 = false;
               } else {
                  boolean var12 = var10 >= '0' && var10 <= '9' || var10 >= 'A' && var10 <= 'Z' || var10 >= 'a' && var10 <= 'z';
                  if(var12) {
                     var11 = true;
                  } else {
                     char[] var13 = class315.field3917;
                     int var14 = 0;

                     label90:
                     while(true) {
                        char var15;
                        if(var14 >= var13.length) {
                           var13 = class315.field3914;

                           for(var14 = 0; var14 < var13.length; ++var14) {
                              var15 = var13[var14];
                              if(var10 == var15) {
                                 var11 = true;
                                 break label90;
                              }
                           }

                           var11 = false;
                           break;
                        }

                        var15 = var13[var14];
                        if(var15 == var10) {
                           var11 = true;
                           break;
                        }

                        ++var14;
                     }
                  }
               }

               if(var11) {
                  char var18 = FileSystem.method4542(var10);
                  if(var18 != 0) {
                     var16.append(var18);
                  }
               }
            }

            if(var16.length() == 0) {
               var4 = null;
            } else {
               var4 = var16.toString();
            }
         } else {
            var4 = null;
         }
      }

      this.cleanName = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1351055761"
   )
   @Export("getName")
   public String getName() {
      return this.name;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   public boolean method5450() {
      return this.cleanName != null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lko;B)I",
      garbageValue = "-108"
   )
   public int method5441(Name var1) {
      return this.cleanName == null?(var1.cleanName == null?0:1):(var1.cleanName == null?-1:this.cleanName.compareTo(var1.cleanName));
   }

   public boolean equals(Object var1) {
      if(var1 instanceof Name) {
         Name var2 = (Name)var1;
         return this.cleanName == null?var2.cleanName == null:(var2.cleanName == null?false:(this.hashCode() != var2.hashCode()?false:this.cleanName.equals(var2.cleanName)));
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.cleanName == null?0:this.cleanName.hashCode();
   }

   public String toString() {
      return this.getName();
   }

   public int compareTo(Object var1) {
      return this.method5441((Name)var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1009820586"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(class314.validInterfaces[var0]) {
         return true;
      } else if(!UnitPriceComparator.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = UnitPriceComparator.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            class314.validInterfaces[var0] = true;
            return true;
         } else {
            if(class189.widgets[var0] == null) {
               class189.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(class189.widgets[var0][var2] == null) {
                  byte[] var3 = UnitPriceComparator.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     class189.widgets[var0][var2] = new Widget();
                     class189.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        class189.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        class189.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            class314.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1796319239"
   )
   static final void method5437() {
      for(GraphicsObject var0 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var0 != null; var0 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
         if(var0.level == class237.plane && !var0.finished) {
            if(Client.gameCycle >= var0.startCycle) {
               var0.method1804(Client.field893);
               if(var0.finished) {
                  var0.unlink();
               } else {
                  class308.region.method3006(var0.level, var0.x, var0.y, var0.height, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }
}
