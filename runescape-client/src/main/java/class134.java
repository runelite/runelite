import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class134 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 325011331
   )
   public static int field2007;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1896065809
   )
   public static int field2008;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1338504821
   )
   static int field2010;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1681393341
   )
   static int field2011;
   @ObfuscatedName("x")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -868559201
   )
   public static int field2013;
   @ObfuscatedName("j")
   public static int[] field2014;
   @ObfuscatedName("v")
   public static boolean field2015;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1158634311
   )
   @Export("authCodeForLogin")
   static int authCodeForLogin;
   @ObfuscatedName("i")
   public static boolean field2018;

   static {
      field2018 = false;
      field2008 = 0;
      field2007 = 0;
      field2015 = false;
      field2013 = 0;
      field2014 = new int[1000];
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1514118798"
   )
   static int method2586(int var0, Script var1, boolean var2) {
      if(var0 == 6200) {
         class83.intStackSize -= 2;
         Client.field1045 = (short)class83.intStack[class83.intStackSize];
         if(Client.field1045 <= 0) {
            Client.field1045 = 256;
         }

         Client.field975 = (short)class83.intStack[class83.intStackSize + 1];
         if(Client.field975 <= 0) {
            Client.field975 = 205;
         }

         return 1;
      } else if(var0 == 6201) {
         class83.intStackSize -= 2;
         Client.field1094 = (short)class83.intStack[class83.intStackSize];
         if(Client.field1094 <= 0) {
            Client.field1094 = 256;
         }

         Client.field1185 = (short)class83.intStack[class83.intStackSize + 1];
         if(Client.field1185 <= 0) {
            Client.field1185 = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         class83.intStackSize -= 4;
         Client.field1159 = (short)class83.intStack[class83.intStackSize];
         if(Client.field1159 <= 0) {
            Client.field1159 = 1;
         }

         Client.field1187 = (short)class83.intStack[class83.intStackSize + 1];
         if(Client.field1187 <= 0) {
            Client.field1187 = 32767;
         } else if(Client.field1187 < Client.field1159) {
            Client.field1187 = Client.field1159;
         }

         Client.field1188 = (short)class83.intStack[class83.intStackSize + 2];
         if(Client.field1188 <= 0) {
            Client.field1188 = 1;
         }

         Client.field1189 = (short)class83.intStack[class83.intStackSize + 3];
         if(Client.field1189 <= 0) {
            Client.field1189 = 32767;
         } else if(Client.field1189 < Client.field1188) {
            Client.field1189 = Client.field1188;
         }

         return 1;
      } else if(var0 == 6203) {
         if(Client.field1102 != null) {
            class91.method1710(0, 0, Client.field1102.width, Client.field1102.height, false);
            class83.intStack[++class83.intStackSize - 1] = Client.camera2;
            class83.intStack[++class83.intStackSize - 1] = Client.camera3;
         } else {
            class83.intStack[++class83.intStackSize - 1] = -1;
            class83.intStack[++class83.intStackSize - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         class83.intStack[++class83.intStackSize - 1] = Client.field1094;
         class83.intStack[++class83.intStackSize - 1] = Client.field1185;
         return 1;
      } else if(var0 == 6205) {
         class83.intStack[++class83.intStackSize - 1] = Client.field1045;
         class83.intStack[++class83.intStackSize - 1] = Client.field975;
         return 1;
      } else {
         return 2;
      }
   }
}
