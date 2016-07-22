import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
@Implements("ClassInfo")
public class class213 extends class211 {
   @ObfuscatedName("r")
   @Export("methods")
   Method[] field3172;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -22525985
   )
   int field3173;
   @ObfuscatedName("o")
   int[] field3174;
   @ObfuscatedName("m")
   @Export("args")
   byte[][][] field3175;
   @ObfuscatedName("g")
   int[] field3176;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1659333557
   )
   int field3177;
   @ObfuscatedName("l")
   @Export("fields")
   Field[] field3178;
   @ObfuscatedName("j")
   int[] field3179;

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(Lclass41;IIII)V",
      garbageValue = "-1516023859"
   )
   static final void method4003(class41 var0, int var1, int var2, int var3) {
      if(client.field412 < 400) {
         if(null != var0.field934) {
            var0 = var0.method797();
         }

         if(null != var0) {
            if(var0.field935) {
               if(!var0.field939 || var1 == client.field463) {
                  String var4 = var0.field920;
                  if(var0.field912 != 0) {
                     var4 = var4 + class53.method1123(var0.field912, class114.field2010.field41) + " " + " (" + "level-" + var0.field912 + ")";
                  }

                  if(client.field531 == 1) {
                     class98.method2276("Use", client.field424 + " " + "->" + " " + class51.method1096(16776960) + var4, 7, var1, var2, var3);
                  } else if(client.field444) {
                     if((class116.field2016 & 2) == 2) {
                        class98.method2276(client.field428, client.field438 + " " + "->" + " " + class51.method1096(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.field910;
                     if(client.field441) {
                        var5 = class87.method1983(var5);
                     }

                     int var6;
                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && !var5[var6].equalsIgnoreCase("Attack")) {
                              byte var7 = 0;
                              if(var6 == 0) {
                                 var7 = 9;
                              }

                              if(var6 == 1) {
                                 var7 = 10;
                              }

                              if(var6 == 2) {
                                 var7 = 11;
                              }

                              if(var6 == 3) {
                                 var7 = 12;
                              }

                              if(var6 == 4) {
                                 var7 = 13;
                              }

                              class98.method2276(var5[var6], class51.method1096(16776960) + var4, var7, var1, var2, var3);
                           }
                        }
                     }

                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(var5[var6] != null && var5[var6].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(client.field355 != class21.field581) {
                                 if(client.field355 == class21.field568 || class21.field570 == client.field355 && var0.field912 > class114.field2010.field41) {
                                    var9 = 2000;
                                 }

                                 int var8 = 0;
                                 if(var6 == 0) {
                                    var8 = 9 + var9;
                                 }

                                 if(var6 == 1) {
                                    var8 = 10 + var9;
                                 }

                                 if(var6 == 2) {
                                    var8 = var9 + 11;
                                 }

                                 if(var6 == 3) {
                                    var8 = 12 + var9;
                                 }

                                 if(var6 == 4) {
                                    var8 = var9 + 13;
                                 }

                                 class98.method2276(var5[var6], class51.method1096(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class98.method2276("Examine", class51.method1096(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }
}
