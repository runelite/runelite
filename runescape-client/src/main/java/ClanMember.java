import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kg")
@Implements("ClanMember")
public class ClanMember extends ChatPlayer {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   class303 field3820;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   class303 field3821;

   ClanMember() {
      this.field3820 = class303.field3842;
      this.field3821 = class303.field3842;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1888442137"
   )
   void method5236() {
      this.field3820 = class303.field3842;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-114"
   )
   public final boolean method5237() {
      if(this.field3820 == class303.field3842) {
         this.method5256();
      }

      return this.field3820 == class303.field3841;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "3"
   )
   void method5256() {
      this.field3820 = RunException.friendManager.field1250.isMember(super.name)?class303.field3841:class303.field3843;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-686329144"
   )
   void method5239() {
      this.field3821 = class303.field3842;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "702090780"
   )
   public final boolean method5240() {
      if(this.field3821 == class303.field3842) {
         this.method5250();
      }

      return this.field3821 == class303.field3841;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1537827834"
   )
   void method5250() {
      this.field3821 = RunException.friendManager.field1249.isMember(super.name)?class303.field3841:class303.field3843;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1461119994"
   )
   public static String method5258(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
            if(var4 == ' ') {
               var2.append('+');
            } else {
               byte var5 = MessageNode.charToByteCp1252(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
