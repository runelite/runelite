import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("p")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("ch")
   static Font field119;
   @ObfuscatedName("l")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("i")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};
   @ObfuscatedName("bl")
   static class184 field122;
   @ObfuscatedName("dy")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("b")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "-503053354"
   )
   static String method167(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         String var4;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var7 = var0.indexOf("%" + var2);
               if(var7 == -1) {
                  break;
               }

               var4 = var0.substring(0, var7);
               int var6 = class107.method2094(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(2 + var7);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var3 = "";
            if(class157.field2116 != null) {
               int var8 = class157.field2116.field1657;
               var4 = (var8 >> 24 & 255) + "." + (var8 >> 16 & 255) + "." + (var8 >> 8 & 255) + "." + (var8 & 255);
               var3 = var4;
               if(class157.field2116.field1659 != null) {
                  var3 = (String)class157.field2116.field1659;
               }
            }

            var0 = var0.substring(0, var2) + var3 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-156718980"
   )
   public static void method176() {
      ItemComposition.field2956.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(IIII)LWidgetNode;",
      garbageValue = "1749877236"
   )
   static final WidgetNode method179(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.field179 = var2;
      Client.componentTable.method2425(var3, (long)var0);
      CombatInfo1.method647(var1);
      Widget var4 = class140.method2681(var0);
      Frames.method1960(var4);
      if(null != Client.field546) {
         Frames.method1960(Client.field546);
         Client.field546 = null;
      }

      Item.method871();
      CombatInfo1.method646(Widget.widgets[var0 >> 16], var4, false);
      class57.method1116(var1);
      if(Client.widgetRoot != -1) {
         class88.method1936(Client.widgetRoot, 1);
      }

      return var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "787293699"
   )
   public static void method180(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.field3235 = var0.readUnsignedByte();
      var2.field3240 = var0.readInt();
      var2.field3237 = new int[var2.field3235];
      var2.field3236 = new int[var2.field3235];
      var2.fields = new Field[var2.field3235];
      var2.field3238 = new int[var2.field3235];
      var2.methods = new Method[var2.field3235];
      var2.args = new byte[var2.field3235][][];

      for(int var3 = 0; var3 < var2.field3235; ++var3) {
         try {
            int var4 = var0.readUnsignedByte();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && var4 != 1 && var4 != 2) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.readString();
                  var6 = var0.readString();
                  var7 = var0.readUnsignedByte();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.readString();
                  }

                  String var20 = var0.readString();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.readInt();
                        var10[var11] = new byte[var12];
                        var0.method2867(var10[var11], 0, var12);
                     }
                  }

                  var2.field3237[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class114.method2267(var8[var12]);
                  }

                  Class var22 = class114.method2267(var20);
                  if(class114.method2267(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class114.method2267(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(Reflection.getMethodName(var16).equals(var6)) {
                        Class[] var17 = Reflection.getParameterTypes(var16);
                        if(var17.length == var21.length) {
                           boolean var18 = true;

                           for(int var19 = 0; var19 < var21.length; ++var19) {
                              if(var21[var19] != var17[var19]) {
                                 var18 = false;
                                 break;
                              }
                           }

                           if(var18 && var22 == var16.getReturnType()) {
                              var2.methods[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.args[var3] = var10;
               }
            } else {
               var5 = var0.readString();
               var6 = var0.readString();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.readInt();
               }

               var2.field3237[var3] = var4;
               var2.field3238[var3] = var7;
               if(class114.method2267(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = Reflection.findField(class114.method2267(var5), var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.field3236[var3] = -1;
         } catch (SecurityException var25) {
            var2.field3236[var3] = -2;
         } catch (NullPointerException var26) {
            var2.field3236[var3] = -3;
         } catch (Exception var27) {
            var2.field3236[var3] = -4;
         } catch (Throwable var28) {
            var2.field3236[var3] = -5;
         }
      }

      class227.field3246.method2432(var2);
   }
}
