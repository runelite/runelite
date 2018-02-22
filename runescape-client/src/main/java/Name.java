import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kp")
@Implements("Name")
public class Name implements Comparable {
   @ObfuscatedName("b")
   @Export("name")
   String name;
   @ObfuscatedName("q")
   @Export("cleanName")
   String cleanName;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lld;)V"
   )
   public Name(String var1, JagexLoginType var2) {
      this.name = var1;
      String var4;
      if(var1 == null) {
         var4 = null;
      } else {
         label133: {
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
            if(var17 >= 1) {
               byte var9;
               if(var2 == null) {
                  var9 = 12;
               } else {
                  switch(var2.field3982) {
                  case 6:
                     var9 = 20;
                     break;
                  default:
                     var9 = 12;
                  }
               }

               if(var17 <= var9) {
                  StringBuilder var15 = new StringBuilder(var17);

                  for(int var18 = var5; var18 < var6; ++var18) {
                     char var10 = var1.charAt(var18);
                     boolean var11;
                     if(Character.isISOControl(var10)) {
                        var11 = false;
                     } else if(class269.method4849(var10)) {
                        var11 = true;
                     } else {
                        char[] var16 = class301.field3790;
                        int var13 = 0;

                        label86:
                        while(true) {
                           char var14;
                           if(var13 >= var16.length) {
                              var16 = class301.field3791;

                              for(var13 = 0; var13 < var16.length; ++var13) {
                                 var14 = var16[var13];
                                 if(var10 == var14) {
                                    var11 = true;
                                    break label86;
                                 }
                              }

                              var11 = false;
                              break;
                           }

                           var14 = var16[var13];
                           if(var14 == var10) {
                              var11 = true;
                              break;
                           }

                           ++var13;
                        }
                     }

                     if(var11) {
                        char var12 = class27.method240(var10);
                        if(var12 != 0) {
                           var15.append(var12);
                        }
                     }
                  }

                  if(var15.length() == 0) {
                     var4 = null;
                  } else {
                     var4 = var15.toString();
                  }
                  break label133;
               }
            }

            var4 = null;
         }
      }

      this.cleanName = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "27"
   )
   @Export("getName")
   public String getName() {
      return this.name;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "255479225"
   )
   public boolean method5359() {
      return this.cleanName != null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lkp;B)I",
      garbageValue = "-77"
   )
   public int method5360(Name var1) {
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

   public int compareTo(Object var1) {
      return this.method5360((Name)var1);
   }

   public String toString() {
      return this.getName();
   }
}
