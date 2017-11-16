import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("bf")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("g")
   static int[] field774;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 308543493
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1687676457
   )
   @Export("owner")
   int owner;
   @ObfuscatedName("r")
   boolean field772;

   WidgetNode() {
      this.field772 = false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I[BLfw;I)V",
      garbageValue = "-287658411"
   )
   static void method1030(int var0, byte[] var1, IndexFile var2) {
      FileSystem var3 = new FileSystem();
      var3.field3260 = 0;
      var3.hash = (long)var0;
      var3.field3258 = var1;
      var3.index = var2;
      Deque var4 = class243.field3291;
      synchronized(class243.field3291) {
         class243.field3291.addFront(var3);
      }

      class29.method220();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfs;II)V",
      garbageValue = "1451164979"
   )
   public static void method1025(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.count = var0.readUnsignedByte();
      var2.field3793 = var0.readInt();
      var2.type = new int[var2.count];
      var2.errorIdentifiers = new int[var2.count];
      var2.fields = new Field[var2.count];
      var2.field3797 = new int[var2.count];
      var2.methods = new Method[var2.count];
      var2.args = new byte[var2.count][][];

      for(int var3 = 0; var3 < var2.count; ++var3) {
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
                        var0.readBytes(var10[var11], 0, var12);
                     }
                  }

                  var2.type[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class56.method775(var8[var12]);
                  }

                  Class var22 = class56.method775(var20);
                  if(class56.method775(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class56.method775(var5).getDeclaredMethods();
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

               var2.type[var3] = var4;
               var2.field3797[var3] = var7;
               if(class56.method775(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = Reflection.findField(class56.method775(var5), var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.errorIdentifiers[var3] = -1;
         } catch (SecurityException var25) {
            var2.errorIdentifiers[var3] = -2;
         } catch (NullPointerException var26) {
            var2.errorIdentifiers[var3] = -3;
         } catch (Exception var27) {
            var2.errorIdentifiers[var3] = -4;
         } catch (Throwable var28) {
            var2.errorIdentifiers[var3] = -5;
         }
      }

      class289.field3803.method3618(var2);
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(Lbd;IIBI)V",
      garbageValue = "-1589750639"
   )
   static final void method1026(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.getSize();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var9 = var0.getSize();
            Client.field888.field2210 = var1;
            Client.field888.field2209 = var2;
            Client.field888.field2213 = 1;
            Client.field888.field2211 = 1;
            class72 var10 = Client.field888;
            int var11 = class13.method82(var4, var5, var9, var10, Client.collisionMaps[var0.field835], true, Client.field1125, Client.field1126);
            if(var11 >= 1) {
               for(int var12 = 0; var12 < var11 - 1; ++var12) {
                  var0.method1069(Client.field1125[var12], Client.field1126[var12], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-558398142"
   )
   static void method1027() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.field943[0] = false;
      Client.menuOptionCount = 1;
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1944615420"
   )
   static final void method1029() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[var1 + 1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[var1 + 1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
               Client.menuOptions[var1 + 1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
               Client.menuTypes[var1 + 1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
               Client.menuActionParams0[var1 + 1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               Client.menuActionParams1[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[var1 + 1] = var4;
               boolean var5 = Client.field943[var1];
               Client.field943[var1] = Client.field943[var1 + 1];
               Client.field943[var1 + 1] = var5;
               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1201074595"
   )
   static void method1028() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[var3 + 1];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
                  Client.field943[var3] = Client.field943[var3 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
