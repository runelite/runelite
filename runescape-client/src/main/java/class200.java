import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("gs")
public class class200 extends CacheableNode {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 121983771
   )
   public int field2885;
   @ObfuscatedName("q")
   public char field2886;
   @ObfuscatedName("t")
   public String field2887;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1517269343
   )
   public int field2888;
   @ObfuscatedName("v")
   public String[] field2889;
   @ObfuscatedName("z")
   public int[] field2890;
   @ObfuscatedName("l")
   public int[] field2891;
   @ObfuscatedName("c")
   static NodeCache field2892;
   @ObfuscatedName("n")
   public char field2893;
   @ObfuscatedName("s")
   static Widget field2894;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1374172996"
   )
   void method3624(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3625(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "87"
   )
   void method3625(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2893 = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.field2886 = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2887 = var1.readString();
      } else if(var2 == 4) {
         this.field2888 = var1.readInt();
      } else {
         int var3;
         if(var2 == 5) {
            this.field2885 = var1.readUnsignedShort();
            this.field2890 = new int[this.field2885];
            this.field2889 = new String[this.field2885];

            for(var3 = 0; var3 < this.field2885; ++var3) {
               this.field2890[var3] = var1.readInt();
               this.field2889[var3] = var1.readString();
            }
         } else if(var2 == 6) {
            this.field2885 = var1.readUnsignedShort();
            this.field2890 = new int[this.field2885];
            this.field2891 = new int[this.field2885];

            for(var3 = 0; var3 < this.field2885; ++var3) {
               this.field2890[var3] = var1.readInt();
               this.field2891[var3] = var1.readInt();
            }
         }
      }

   }

   static {
      field2892 = new NodeCache(64);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1071290333"
   )
   static final void method3626() {
      for(class25 var0 = (class25)Client.field415.method2828(); var0 != null; var0 = (class25)Client.field415.method2830()) {
         if(var0.field582 == -1) {
            var0.field581 = 0;
            class105.method2020(var0);
         } else {
            var0.unlink();
         }
      }

   }

   class200() {
      this.field2887 = "null";
      this.field2885 = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "5"
   )
   static final boolean method3637(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else if(class178.method3265(var0)) {
         return true;
      } else {
         char[] var1 = class211.field3136;

         int var2;
         char var3;
         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var0 == var3) {
               return true;
            }
         }

         var1 = class211.field3138;

         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var0 == var3) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "-508163198"
   )
   public static void method3639(File var0) {
      class120.field1866 = var0;
      if(!class120.field1866.exists()) {
         throw new RuntimeException("");
      } else {
         class107.field1721 = true;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1977253204"
   )
   public static void method3641(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.field3257 = var0.readUnsignedByte();
      var2.field3258 = var0.readInt();
      var2.field3263 = new int[var2.field3257];
      var2.field3259 = new int[var2.field3257];
      var2.fields = new Field[var2.field3257];
      var2.field3261 = new int[var2.field3257];
      var2.methods = new Method[var2.field3257];
      var2.args = new byte[var2.field3257][][];

      for(int var3 = 0; var3 < var2.field3257; ++var3) {
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

                  var2.field3263[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = CombatInfoListHolder.method724(var8[var12]);
                  }

                  Class var22 = CombatInfoListHolder.method724(var20);
                  if(CombatInfoListHolder.method724(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = CombatInfoListHolder.method724(var5).getDeclaredMethods();
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

               var2.field3263[var3] = var4;
               var2.field3261[var3] = var7;
               if(CombatInfoListHolder.method724(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = Reflection.findField(CombatInfoListHolder.method724(var5), var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.field3259[var3] = -1;
         } catch (SecurityException var25) {
            var2.field3259[var3] = -2;
         } catch (NullPointerException var26) {
            var2.field3259[var3] = -3;
         } catch (Exception var27) {
            var2.field3259[var3] = -4;
         } catch (Throwable var28) {
            var2.field3259[var3] = -5;
         }
      }

      class231.field3265.method2787(var2);
   }
}
