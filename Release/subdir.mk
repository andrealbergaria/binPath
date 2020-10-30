################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../binPath.c \
../binPath_16_32_64bits.c \
../crypto.c \
../getBinariesFromDecimals.c \
../printAllCombs.c \
../util.c 

O_SRCS += \
../binPath.o \
../crypto.o \
../printAllCombs.o \
../util.o 

OBJS += \
./binPath.o \
./binPath_16_32_64bits.o \
./crypto.o \
./getBinariesFromDecimals.o \
./printAllCombs.o \
./util.o 

C_DEPS += \
./binPath.d \
./binPath_16_32_64bits.d \
./crypto.d \
./getBinariesFromDecimals.d \
./printAllCombs.d \
./util.d 


# Each subdirectory must supply rules for building sources it contributes
%.o: ../%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


