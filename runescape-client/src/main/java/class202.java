import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class202 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)V",
      garbageValue = "493058944"
   )
   public static void method3649(class159 var0) {
      ClassInfo var1 = (ClassInfo)class227.field3231.method2295();
      if(null != var1) {
         int var2 = var0.offset;
         var0.method2711(var1.field3225);

         for(int var3 = 0; var3 < var1.field3223; ++var3) {
            if(var1.field3224[var3] != 0) {
               var0.method2708(var1.field3224[var3]);
            } else {
               try {
                  int var4 = var1.field3226[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2708(0);
                     var0.method2711(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     var5.setInt((Object)null, var1.field3227[var3]);
                     var0.method2708(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.method2708(0);
                     var0.method2711(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.method2708(0);
                        var0.method2711(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = var25.invoke((Object)null, var7);
                     if(var11 == null) {
                        var0.method2708(0);
                     } else if(var11 instanceof Number) {
                        var0.method2708(1);
                        var0.method2713(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2708(2);
                        var0.method2714((String)var11);
                     } else {
                        var0.method2708(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2708(-10);
               } catch (InvalidClassException var14) {
                  var0.method2708(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2708(-12);
               } catch (OptionalDataException var16) {
                  var0.method2708(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2708(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2708(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2708(-16);
               } catch (SecurityException var20) {
                  var0.method2708(-17);
               } catch (IOException var21) {
                  var0.method2708(-18);
               } catch (NullPointerException var22) {
                  var0.method2708(-19);
               } catch (Exception var23) {
                  var0.method2708(-20);
               } catch (Throwable var24) {
                  var0.method2708(-21);
               }
            }
         }

         var0.method2724(var2);
         var1.unlink();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "37"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class47.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method863(var0, var1, var2, var3);
      class47.field927.method2242(var5, (long)var5.id);
      class47.field922.method2389(var5);
      Client.field357 = Client.field358;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1129796408"
   )
   static final void method3651(boolean var0) {
      for(int var1 = 0; var1 < Client.field332; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field333[var1]];
         int var3 = 536870912 + (Client.field333[var1] << 14);
         if(null != var2 && var2.vmethod699() && var0 == var2.composition.isVisible && var2.composition.method3573()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field645 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field559[var4][var5] == Client.field397) {
                     continue;
                  }

                  Client.field559[var4][var5] = Client.field397;
               }

               if(!var2.composition.field3037) {
                  var3 -= Integer.MIN_VALUE;
               }

               class0.region.method1713(class118.plane, var2.x, var2.y, XClanMember.method223(var2.x + (var2.field645 * 64 - 64), var2.field645 * 64 - 64 + var2.y, class118.plane), var2.field645 * 64 - 64 + 60, var2, var2.angle, var3, var2.field607);
            }
         }
      }

   }
}
